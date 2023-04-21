class Node {
    int data;
    Node next;
    Node (int data) {
        this.data = data;
        this.next = null;
    }

} 
interface CrlLL {
    public void addLast(int data);
    public void addAtIndex(int index, int data);
    public void printList();
    public void deleteAtIndex(int index);
}
class ClrLinkedList implements CrlLL {
    private Node head;
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            head.next = newNode;
            return;
        }
        Node firstNode = head;
        while (firstNode.next != head) {
            firstNode = firstNode.next;
        }
        firstNode.next = newNode;
        newNode.next = head;
    }

    public void printList() {
        Node currentNode = head;
        do {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }while(currentNode != head);
    }
    public void addAtIndex(int index, int data){
        Node newNode = new Node(data);
        if(index == 0) {
            Node firstNode = head;
            while (firstNode.next != head) {
                firstNode = firstNode.next;
            }
            firstNode.next = newNode;
            newNode.next = head;
            head = newNode;
            return;
        }
        int count = 0;
        Node frontNode = head;
        Node backNode = head;
        while (index >= 1 && backNode.next != head) {
            count++;
            frontNode = backNode;
            backNode = backNode.next;
            if(count == index) {
                frontNode.next = newNode;
                newNode.next = backNode;
                return;
            }
        }
        if(count != index) {
            System.out.println("index out of bound:");
        }
    }

    public void deleteAtIndex(int index) {
        if(index == 0) {
            Node firstNode = head;
            while (firstNode.next != head) {
                firstNode = firstNode.next;
            }
            firstNode.next = head.next;
            head = head.next;
            return;    
        }
        int count = 0;
        Node frontNode = head;
        Node backNode = head;
        while(index >= 1 && backNode.next != head) {
            count++;
            frontNode = backNode;
            backNode = backNode.next;
            if(count == index) {
                frontNode.next = backNode.next;
                return;
            }
        }
        if(count != index) {
            System.out.println("index out of bound:");
        }
    }

}
class ClrLinkedListImpl {
    public static void main (String arr[]) {
        ClrLinkedList  l = new ClrLinkedList();
        l.addLast(172);
        l.addLast(162);
        l.addLast(152);
        l.addLast(142);
        l.addLast(132);
        l.deleteAtIndex(1);
        l.printList();
    }
}