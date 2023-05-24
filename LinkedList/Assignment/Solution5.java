public class Solution5 {
    // Function to merge two sorted linked lists and return the head of the merged
    // list
    public static Node SortedMerge(Node a, Node b) {
        Node result = null;

        // If one of the linked lists is null, return the other one
        if (a == null)
            return b;
        else if (b == null)
            return a;

        // Choose the smaller node as the head of the merged list, and recursively merge
        // the remaining lists
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        } else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return result;
    }

    // Function to merge k sorted linked lists and return the head of the merged
    // list
    public static Node mergeKLists(Node arr[], int last) {
        while (last != 0) {
            int i = 0, j = last;

            // Merge pairs of linked lists into a single sorted linked list
            while (i < j) {
                arr[i] = SortedMerge(arr[i], arr[j]);
                i++;
                j--;

                // If all pairs have been merged, set last to the last merged list
                if (i >= j)
                    last = j;
            }
        }
        return arr[0]; // Return the head of the merged list
    }

    // Function to print the elements of a linked list
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String args[]) {
        int k = 3; // Number of linked lists to merge
        int n = 4; // Number of elements in each linked list
        Node arr[] = new Node[k]; // Array to store the heads of the linked lists

        // Initialize the linked lists with sample data
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        // Merge the k linked lists and print the result
        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }
}

// Node class to represent a node in the linked list
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
