import java.util.Scanner; 
class Node {
    int data ;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
 }
 interface List {
    public void addFirst(int data);
    public void addLast(int data);
    public void deleteFirst();
    public void deleteLast();
    public void addNode(int index, int data);
    public void deleteNode(int index);
    public int getSize();
    public void printList();
 }
class LinkedList implements List {
    private Node head; 
    private int size = 0;
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
        Node firstNode = head;
        while (firstNode.next != null) {
            firstNode = firstNode.next;
        }
        firstNode.next = newNode;
        size++;
    }

    public void printList() {
        if(head == null) {
            System.out.println("list is empty:");
        }
        Node firstNode = head;
        while (firstNode != null) {
            System.out.print(firstNode.data + " ");
            firstNode = firstNode.next;
        }
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("list is empty:");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteNode(int index) {
        if (head == null) {
            System.out.println("list is empty:");
            return;
        }
        Node frontNode = head;
        Node backNode = head;
        int count = 0;
        if (index == 0) {
            deleteFirst();
            return;
        }
        while(index >= 0 & backNode.next != null ) {
            count++;
            frontNode = backNode;
            backNode = backNode.next;
            if(index == count) {
                frontNode.next = backNode.next;
                size--;
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
        Node frontNode = head;
        Node backNode = head;
        while( index >= 0 & backNode.next != null ) {
            count++;
            frontNode = backNode;
            backNode = backNode.next;
            if(index == count) {
                frontNode.next = newNode;
                newNode.next = backNode;
                size++;
                return;
            }
        }
    }

    public void  deleteLast() {
        if (head == null) {
            System.out.println("list is empty:");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node frontNode = head;
        Node backNode = head;
        while (backNode.next  != null) {
            frontNode = backNode;
            backNode = backNode.next;
        }
        frontNode.next = null;
        size--;
    }

    public int getSize() {
        return size;
    }

}
public class LinkedListImpl {
    public static void main (String [] args) {
        LinkedList l = new LinkedList();
        int temp = 1;
        Scanner sc = new  Scanner(System.in);
        while (temp != 0) { 
            System.out.println("\n\n\nenter 1 addfirst:");
            System.out.println("enter 2 to addlast:");
            System.out.println("enter 3 to deletefirst:");
            System.out.println("enter 4 to deletelast:");
            System.out.println("enter 5 to deleteNode:");
            System.out.println("enter 6 to addNode:");
            System.out.println("enter 7 to printlist:");
            System.out.println("enter 8 to getsize:");
            System.out.println("enter 0 to exit:");
            int choice = sc.nextInt();
            if(choice == 1) {
                System.out.println("enter element to be added:");
                int data1 = sc.nextInt();
                l.addFirst(data1);
            }
            else if(choice == 2) {
                System.out.println("enter element to be added:");
                int data2 = sc.nextInt();
                l.addLast(data2);
            }
            else if(choice == 3) {
                l.deleteFirst();
            }
            else if(choice == 4) {
                l.deleteLast();
            }
            else if(choice == 5) {
                System.out.println("enter index value:");
                int index = sc.nextInt();
                l.deleteNode(index);
            }
            else if (choice == 6) {
                System.out.println("enter element to be added and index:");
                int data3 = sc.nextInt();
                int index = sc.nextInt();
                l.addNode(index,data3);
            }
            else if (choice == 7) {
                l.printList();
            }
            else if(choice == 8) {
                l.getSize();
            }
            else if (choice == 0) {
                temp  = 0;
            }
            else {
                System.out.println("invalid choice:");
            }
        }
    }
}
