import java.util.*;

public class Question3 {
    // Function to push an element to the bottom of the stack
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // Base Case
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        // Recursion
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Function to reverse a stack
    public static void reverseStack(Stack<Integer> s) {
        // Base Case
        if (s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // Function to print all elements of a stack
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // Reverse the stack
        reverseStack(s);

        // Print the reversed stack
        printStack(s);
    }
} 
