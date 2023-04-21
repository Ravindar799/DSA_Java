import java.util.Scanner;
class Node {
    int data;
    Node prev;
    Node next;
    Node (int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

}
interface Doubly {
    public void addFirst(int data);
    public void addLast(int data);
    public void printList();
    public void deleteFirst();
    public void deleteLast();
    public void deleteNode(int index);
    public void addNode(int index, int data);
}
class DoublyLL implements Doubly {
    private Node head;
    public void addFirst(int data) {
    Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node frontNode = head;
        while (frontNode.next != null) {
            frontNode = frontNode.next;
        }
        frontNode.next = newNode;
        newNode.prev = frontNode.next;
    }

     public void printList() {
        if(head == null) {
            System.out.println("list is empty:");
            return;
        }
        Node frontNode = head;
        while (frontNode != null) {
            System.out.print(frontNode.data + " ");
            frontNode = frontNode.next;
        }
    }

    public void deleteFirst() { 
        if(head == null) {
           System.out.println("doubly Linked list is empty:");
            return;
        }
        head = head.next;
        head.next.prev = null;
    }

    public void deleteLast() {
        if(head == null) {
           System.out.println("doubly Linked list is empty:");
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node frontNode = head;
        Node backNode = head;
        while (backNode.next != null) {
            frontNode = backNode;
            backNode = backNode.next;
        }
        frontNode.next = null;
    }

    public void deleteNode(int index) {
        if(head == null) {
            System.out.println("LinkedList is empty:");
            return;
        }
        if(index == 0){
            deleteLast();
            return;
        }
        int count = 0;
        Node frontNode = head;
        Node backNode = head;
        while (index >= 0 & backNode.next != null) {
            count++;
            frontNode = backNode;
            backNode = backNode.next;
            if(count == index){
                frontNode.next = backNode.next;
            }
        }
    }

    public void addNode(int index, int data) {
        Node newNode = new Node(data);
        if(head == null) {
            System.out.println("LinkedList is empty:");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }
        int count = 0;
        Node frontNode = head;
        Node backNode = head;
        while(backNode.next != null) {
            count++;
            frontNode = backNode;
            backNode = backNode.next;
            if(count == index) {
                newNode.next = backNode;
                newNode.prev = frontNode;
                frontNode.next = newNode;
                backNode.prev = newNode;
            }
        }
    } 

}
public class DoublyLinkedListImpl {
    public static void main (String [] args) {
        DoublyLL l = new DoublyLL();
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
            else if (choice == 0) {
                temp  = 0;
            }
            else {
                System.out.println("invalid choice:");
            }
        }
    }

}
