 class Node {
      int data ;
      Node next;
      Node(int data) {
        this.data = data;
        this.next = null;
      }
}
class LinkedList {
    Node head; 
    private int size;
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        newNode.next = head ;
        head  = newNode; 
        size++;
    }
    public void  addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            size++;
            return;
        }
        Node currnode = head;
        while (currnode.next != null) {
            currnode = currnode.next;
        }
        currnode.next = newNode;
        size++;
    }
    public void printList() {
        if(head == null) {
            System.out.println("list is empty:");
        }
        Node currnode = head;
        while (currnode != null) {
            System.out.print(currnode.data + " ");
            currnode = currnode.next;
        }

    }
    public void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty:");
            size--;
            return;
        }
        head = head.next;
        size--;
    }
    public void deleteNode(int index) {
        if (head == null) {
            System.out.println("list is empty:");
            size--;
            return;
        }
        Node currnode = head;
        Node secondnode = head;
        int count = 0;
        if (index == 0) {
                head = head.next;
                return;
            }
        while(secondnode.next != null ) {
            count++;
            currnode = secondnode;
            secondnode = secondnode.next;
            if(index == count) {
                currnode.next = secondnode.next;
                return;
            }
        }
        if (index != count) {
            System.out.println("index out of bound:");
        }
    }
    public void addNode(int index,int data) { 
        Node newNode = new Node(data);
        if (head == null) {
            System.out.println("list is empty:");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        int count =0;
        Node currnode = head;
        Node secondnode = head;
        while(secondnode.next != null ) {
            count++;
            currnode = secondnode;
            secondnode = secondnode.next;
            if(index == count) {
                currnode.next = newNode;
                newNode.next = secondnode;
                return;
            }
        }
    }
    public void  deleteLast() {
        if (head == null) {
            System.out.println("list is empty:");
            return;
        }
        Node currnode = head;
        Node secondnode = head;
        while (secondnode.next  != null) {
            currnode = secondnode;
            secondnode = secondnode.next;
        }
        currnode.next = null;
        size--;
    }
    public int size() {
        return size;
    }
}
public class LinkedListImpl {
    public static void main (String [] args) {
        LinkedList l = new LinkedList();
        l.addLast(10);
        l.addLast(20);
        l.addLast(30);
        l.addLast(40);
        l.addLast(50);
        l.addLast(60);
        l.deleteNode(0);
        l.addLast(70);
        l.addLast(80);
        l.addNode(7,700);
        l.deleteNode(6);
        l.deleteLast();
        l.addNode(1,30000);
        l.printList();

    }
}
