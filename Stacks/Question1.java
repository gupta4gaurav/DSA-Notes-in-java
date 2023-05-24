import java.util.*;

public class Question1 {

    // This function recursively pops the elements from the stack and pushes
    // the given data to the bottom of the stack, and then pushes the popped
    // elements back on top
    public static void pushAtBottom(Stack<Integer> stack, int data) {
        // Base Case
        if (stack.isEmpty()) {
            int top = stack.push(data);
            return;
        }
        // Recursive case
        int top = stack.pop(); // Pop the top element
        pushAtBottom(stack, data); // Recursively push the data to the bottom of the stack
        stack.push(top); // Push the popped element back on top of the stack
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push some elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Call the pushAtBottom function to push a new element to the bottom of the
        // stack
        pushAtBottom(stack, 5);

        // Pop and print all elements from the stack until it is empty
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}