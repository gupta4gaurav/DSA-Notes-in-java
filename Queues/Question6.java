import java.util.*;
import java.util.LinkedList;

public class Question6 {
    // Function to reverse the order of elements in a queue
    public static void reverseQueue(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>(); // Create a stack to store the elements

        // Move all elements from the queue to the stack
        while (!q.isEmpty()) {
            s.push(q.remove()); // Remove element from the front of the queue and push it to the stack
        }

        // Move all elements from the stack back to the queue, reversing their order
        while (!s.isEmpty()) {
            q.add(s.pop()); // Pop element from the top of the stack and add it to the back of the queue
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        reverseQueue(q); // Reverse the order of elements in the queue

        // Print the elements in the reversed order
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
