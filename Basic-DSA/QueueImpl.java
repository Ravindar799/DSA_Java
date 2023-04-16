class Queue {
    int queue [] = new int [5];
    int front ;
    int end ;
    int size ;
    public void enQueue(int data) {
        if(size >=5) {
            System.out.println("queue is full");
        }
        else {
            queue[end] = data;
            end++;
            size++;
        }
    }
    public int  deQueue () {
        int data =0;
        if(front > end) {
            System.out.println("queue is empty");
        }
        else {
            data = queue[front];
            front ++;
            size--;
        }
        return data;
    }
    public void show () {
        for (int i = 0; i<size ; i++) {
            System.out.println(queue[front+i]);
        }
    }
     public boolean isEmpty() {
        return size == 0;
    }
}
public class QueueImpl {
    public static void main (String arr[]) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.enQueue(19);
        System.out.println(q.isEmpty());
        q.deQueue();
        q.deQueue();
        q.deQueue();

    }
}
 