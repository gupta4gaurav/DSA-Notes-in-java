import java.util.*;
import java.util.LinkedList;

public class Question5 {
    // Function to interleave the elements of a queue
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size(); // Get the size of the queue (number of elements)

        // Move the first half of elements to a separate queue
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }

        // Interleave the elements of the two queues
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove()); // Add element from firstHalf queue to the main queue
            q.add(q.remove()); // Add element from the main queue to maintain interleaving
        }
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeave(q);

        // Print the interleaved queue
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
