public class Solution4 {
    Node head; // head of the linked list

    // Node class to represent a node in the linked list
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to segregate even and odd nodes in the linked list
    void segregateEvenOdd() {
        Node end = head; // node to keep track of the end of the linked list
        Node prev = null; // node to keep track of the previous node while traversing
        Node curr = head; // node to traverse the linked list

        // Traverse to the end of the linked list
        while (end.next != null)
            end = end.next;

        Node new_end = end; // node to keep track of the new end of the linked list after rearranging

        // Move all odd nodes to the end of the linked list
        while (curr.data % 2 != 0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        // If the first node is even, update the head of the linked list
        if (curr.data % 2 == 0) {
            head = curr;

            // Traverse through the remaining nodes and rearrange the list
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    new_end.next = curr;
                    new_end = curr;
                    curr = prev.next;
                }
            }
        } else {
            prev = curr;
        }

        // If the last node is odd, update the end of the linked list
        if (new_end != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }
    }

    // Function to insert a new node at the beginning of the linked list
    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    // Function to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Solution4 llist = new Solution4();

        // Insert nodes at the beginning of the linked list
        llist.push(11);
        llist.push(10);
        llist.push(8);
        llist.push(6);
        llist.push(4);
        llist.push(2);
        llist.push(0);

        System.out.println("Linked List");
        llist.printList();

        // Segregate even and odd nodes in the linked list
        llist.segregateEvenOdd();

        System.out.println("Updated Linked List");
        llist.printList();
    }
}
