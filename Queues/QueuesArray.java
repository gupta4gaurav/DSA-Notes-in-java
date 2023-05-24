public class QueuesArray {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        // Constructor to initialize the queue
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        // Check if the queue is empty
        public boolean isEmpty() {
            return rear == -1;
        }

        // Add function to insert an element into the queue
        public void add(int data) {
            // Check if the queue is full
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // Remove function to remove an element from the queue
        public int remove() {
            // Check if the queue is empty
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }

            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        // Peek function to get the front element of the queue
        public int peek() {
            // Check if the queue is empty
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
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
