class Node {
    int data;
    Node next;
    Node (int data) {
        this.data = data;
        this.next = null;
    }
}
class StackImpl {
    Node head;
    public void push(int data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public int  pop () {
        if(head == null) {
            System.out.println("Stack is empty:");
        }
        int top  = head.data;
        head = head.next;
        return top;
    }
    public void printList() {
        Node temp = head; 
        while (temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }
    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return 0;
        }
        return head.data;
    }
    public boolean isEmpty() {
        return head == null;
    }
}
public class StackImplUsgLL {
    public static void main (String arr[]) {
        StackImpl s = new StackImpl();
        s.push(12);
        s.push(34);
        s.push(45);
        s.push(55);
        System.out.println(s.pop() +" ");
        s.printList();
        System.out.println("\n"+ s.peek());
    }
}