import java.util.*;
public class JCF {
    public static void main(String[] args) {
        //Queue <Integer> q = new LinkedList<>();
        Queue <Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);

        // Print and remove elements from the queue until it becomes empty
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
