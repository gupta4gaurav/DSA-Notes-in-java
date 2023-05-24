// Double Linked List class

import javax.swing.plaf.ColorUIResource;

public class DoubleLL {
    // Node class for creating a node of a doubly linked list
    public class Node {
        int data; // Data of the node
        Node next; // Pointer to next node
        Node prev; // Pointer to previous node
        // Constructor to create a node with given data

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static int size; // Size of the list
    public static Node head; // Head of the list
    public static Node tail; // Tail of the list

    // Method to add a node at the beginning of the list
    public void addFirst(int data) {
        // Step - 1 -> To create Node
        Node newNode = new Node(data);
        size++;

        if (head == null) { // Corner case
            head = tail = newNode;
            return;
        }

        // Step - 2 -> To Create new node head = Head
        newNode.next = head; // Linking

        // Step - 3 -> to create head prev to newNode
        head.prev = newNode;

        // Step - 4 -> To create head = New Node
        head = newNode;
    }

    // Method to add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Method to remove the first node from the list
    public int removeFirst() {
        if (head == null) {
            System.out.println("Dll is empty.");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    // Method to remove the last node from the list
    public int removeLast() {
        if (head == null) {
            System.out.println("Dll is empty.");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    // Method to print the list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // Reverse a Double Linked list
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
           next = curr.next;
           curr.next = prev;
           curr.prev = next;

           prev = curr;
           curr = next;
        }
        head = prev;
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(dll.size);
        dll.reverse();
        dll.print();
    }
}