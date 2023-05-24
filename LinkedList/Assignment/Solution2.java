public class Solution2 {
    // Linked List Node
    static class Node {
        int data;
        Node next;
    };

    // Function to insert a node at the beginning of the Linked List
    static Node push(Node head_ref, int new_data) {
        Node new_node = new Node();
        new_node.data = new_data;
        new_node.next = (head_ref);
        (head_ref) = new_node;
        return head_ref;
    }

    // Function to print the Linked List
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.printf("%d ", temp.data);
            temp = temp.next;
        }
        System.out.printf("\n");
    }

    // Function to skip M nodes and delete N nodes of a Linked List
    static void skipMdeleteN(Node head, int M, int N) {
        Node curr = head, t;
        int count;
        while (curr != null) {
            // Skip M nodes
            for (count = 1; count < M && curr != null; count++) {
                curr = curr.next;
            }
            // If we have reached end of the list, return
            if (curr == null) {
                return;
            }
            // Store the next node after skipping M nodes
            t = curr.next;
            // Delete N nodes
            for (count = 1; count <= N && t != null; count++) {
                Node temp = t;
                t = t.next;
            }
            // Update the link of the previous node to the next node after deleting N nodes
            curr.next = t;
            // Set the current node to the next node after deleting N nodes
            curr = t;
        }
    }

    public static void main(String args[]) {
        Node head = null;
        int M = 2, N = 3;
        // Insert nodes at the beginning of the Linked List
        head = push(head, 10);
        head = push(head, 9);
        head = push(head, 8);
        head = push(head, 7);
        head = push(head, 6);
        head = push(head, 5);
        head = push(head, 4);
        head = push(head, 3);
        head = push(head, 2);
        head = push(head, 1);
        System.out.printf("M = %d, N = %d \n" + "Linked list we have is :\n", M, N);
        // Print the original Linked List
        printList(head);
        // Delete N nodes after skipping M nodes
        skipMdeleteN(head, M, N);
        System.out.printf("\nLinked list on deletion is :\n");
        // Print the resulting Linked List
        printList(head);
    }
}
