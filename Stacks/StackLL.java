import java.util.LinkedList;

public class StackLL {
    // Node class for creating linked list nodes
    static class Node {
        int data; // Data stored in node
        Node next; // Pointer to next node in linked list

        // Constructor to create new node with given data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack class implemented using linked list
    static class Stack {
        static Node head = null; // Pointer to head of linked list (top of stack)

        // Check if stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Push a new element onto the stack
        public void push(int data) {
            Node newNode = new Node(data); // Create new node with given data

            // If stack is empty, set the new node as the head and return
            if (isEmpty()) {
                head = newNode;
                return;
            }

            // Otherwise, add the new node to the top of the stack
            newNode.next = head;
            head = newNode;
        }

        // Pop the top element from the stack and return its value
        public int pop() {
            // If stack is empty, return -1 to indicate an error
            if (isEmpty()) {
                return -1;
            }

            int top = head.data; // Store the value of the top element

            // Set the second element in the linked list as the new head (top of stack)
            head = head.next;

            return top; // Return the value of the popped element
        }

        // Peek at the value of the top element in the stack without removing it
        public int peek() {
            // If stack is empty, return -1 to indicate an error
            if (isEmpty()) {
                return -1;
            }

            return head.data; // Return the value of the top element
        }
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Stack stack = new Stack(); // Create a new stack

        // Push some elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Pop and print all elements from the stack until it is empty
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
