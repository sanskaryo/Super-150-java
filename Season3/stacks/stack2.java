import java.util.*;

public class stack2 {
    private int[] arr;
    private int idx = -1;

    // Constructor with default size
    public stack2() {
        arr = new int[5];
    }

    // Constructor with custom size
    public stack2(int n) {
        arr = new int[n];
    }

    public boolean isEmpty() {
        return idx == -1;
    }

    public void push(int item) throws Exception {
        if(isFull()) {
            throw new Exception("Stack is Full");
        }
        idx++;
        arr[idx] = item;
    }

    public int size() {
        return idx + 1;
    }

    public boolean isFull() {
        return idx == arr.length - 1;
    }

    public int pop() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is Empty");
        }
        int rv = arr[idx];
        idx--;
        return rv;
    }

    public int peek() throws Exception {
        if(isEmpty()) {
            throw new Exception("Stack is Empty");
        }
        return arr[idx];
    }

    public void display() {
        for(int i = 0; i <= idx; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        try {
            stack2 stack = new stack2(5); // Create stack of size 5
            
            // Test push operation
            stack.push(10);
            stack.push(20);
  
            stack.push(40);
            stack.push(50);
            stack.push(60);
            
            System.out.println("Stack after pushing elements:");
            stack.display();  // Output: 10 20 30
            
            // Test pop operation
            System.out.println("Popped element: " + stack.pop());  // Output: 30
            
            // Test peek operation
            System.out.println("Top element: " + stack.peek());    // Output: 20
            
            // Test size
            System.out.println("Stack size: " + stack.size());     // Output: 2
            
            // Display final stack
            System.out.println("Final stack:");
            stack.display();  // Output: 10 20
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
