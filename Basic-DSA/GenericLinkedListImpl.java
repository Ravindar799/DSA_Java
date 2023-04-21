class Node<T> {
    T data;
    Node<T> next;
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

interface GenericList<T> {
    public void addFirst(T data);
    public void addLast(T data);
    public void deleteFirst();
    public void deleteLast();
    public void printList();
    public void addAtIndex(int index, T data);
    public void deleteAtIndex(int index);
}

class GenericLL<T> implements GenericList<T> {
    Node<T> head;

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node<T> firstNode = head;
        while(firstNode.next != null)  {
            firstNode = firstNode.next;
        }
        firstNode.next = newNode;
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("list is empty:");
            return;
        }
        head = head.next;
    }
    
    public void deleteLast() {
        if(head == null) {
            System.out.println("list is empty:");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node<T> firstNode = head;
        Node<T> secondNode = head;
        while (secondNode.next != null) {
            firstNode = secondNode;
            secondNode = secondNode.next;
        }
        firstNode.next = null;
    }  
    public void addAtIndex(int index, T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            System.out.println("list is empty:");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        int count = 0;
        Node<T> firstNode = head;
        Node<T> secondNode = head;
        while (index >= 1 & secondNode.next != null){
            count++;
            firstNode = secondNode;
            secondNode = secondNode.next;
            if(count == index) {
                firstNode.next = newNode;
                newNode.next = secondNode;
                return;
            }
        }
        if (index != count) {
            System.out.println("index out of bound:");
        }
    }

    public void deleteAtIndex(int index) { 
        if(head == null) {
            System.out.println("list is empty:");
            return;
        }
        if(index == 0) {
            deleteFirst();
            return;
        }
        int count = 0;
        Node<T> firstNode = head;
        Node<T> secondNode = head;
        while(index >= 1 & secondNode.next != null) {
            count++;
            firstNode = secondNode;
            secondNode = secondNode.next;
            if(count == index) {
                firstNode.next = secondNode.next;
                return;
            }
        }
        if (index != count) {
            System.out.println("index out of bound:");
        }
        
    }
}

class GenericLinkedListImpl {
    public static void main(String[] args) {
        GenericLL<String> gl = new GenericLL<>();
        gl.addFirst("ravindar:");
        gl.addFirst("sai");
        gl.addFirst("rohan");
        gl.addFirst("raja");
        gl.addFirst("preeti vishnu");
        gl.addLast("ravindardeeti:");
        gl.deleteFirst();
        gl.addAtIndex(3,"tempppp");
        gl.deleteAtIndex(3);
        gl.deleteLast();
        gl.printList();
    }
}
