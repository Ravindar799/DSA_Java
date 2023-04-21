class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Queue {
    Node head;
    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
           return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    public int  deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty:");
            return 0;
        }
        int top = head.data;
        head = head.next;
        return top;    
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void printList(){
        if (isEmpty()) {
            System.out.println("queue is empty:");
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
}
public class QueueImplUsgLL {
    public static void main (String arr[]) {
        Queue q = new Queue();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.deQueue();
        q.printList();
        q.deQueue();

    }
}