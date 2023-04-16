class Temp {
    int stack[] = new int[5];
    int top = 0;

    public void push(int num) {
        if(top >= 5) {
            System.out.println("stack is full");
        }
        else {
            stack[top] = num;
            top++;
        }
    }

    public int pop() { 
        int ans = 0;
        if(isEmpty()) {
            System.out.println(" stack is empty");
        }
        else {
            top--;
            ans = stack[top];
            stack[top] = 0;
        }
        return ans;
        
    }
    public int peek() {
        return stack[top-1];
    }
    public int size() {
        return top;
    }
    public void show () {
        for (int n : stack) {
            System.out.println(n);
        }
    }  
    public boolean isEmpty() {
        return top<=0;
    }
}

public class Stack {
    public static void main(String[] args) {
        Temp nums = new Temp();
        nums.push(10);
        nums.pop();
        nums.pop();
        nums.pop();
    }
}
