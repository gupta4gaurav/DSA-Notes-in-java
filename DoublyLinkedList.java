import java.util.Scanner;

public class DoublyLinkedList {

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;

    public void append(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        }
        newNode.prev = tail;
        tail = newNode;
        if (head == null) {
            head = newNode;
        }
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head != null) {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void delete(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == tail) {
            tail = node.prev;
        }
    }

    public void insert(int index, int value) {
        if (index == 0) {
            prepend(value);
            return;
        }

        Node current = head;
        int currentIndex = 0;
        while (current != null && currentIndex < index) {
            current = current.next;
            currentIndex++;
        }

        if (currentIndex == index) {
            Node newNode = new Node(value);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a value to insert into the list (0 to quit): ");
            int value = scanner.nextInt();
            if (value == 0) {
                break;
            }

            System.out.println("Enter the index at which to insert the value: ");
            int index = scanner.nextInt();
            list.insert(index, value);
        }

        System.out.println("List with inserted");
    }
}