public class Question1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        // Check if the queue is empty
        public boolean isEmpty() {
            return head == null && tail == null;
        }

        // Add function to insert an element into the queue
        public void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // Remove function to remove an element from the queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            int front = head.data;

            // Single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // Peek function to get the front element of the queue
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
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
