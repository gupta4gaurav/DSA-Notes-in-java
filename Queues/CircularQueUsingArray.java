public class CircularQueUsingArray {
    static class Queue {
        static int size;
        static int rear;
        static int front;
        static int[] arr;

        // Constructor to initialize the circular queue
        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // Check if the circular queue is empty
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // Check if the circular queue is full
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // Add function to insert an element into the circular queue
        public void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            // Add the first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // Remove function to remove an element from the circular queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            int result = arr[front];

            // Remove the last element
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // Peek function to get the front element of the circular queue
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        // Print and remove elements from the circular queue until it becomes empty
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
