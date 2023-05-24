public class Solution3 {
    public class Node {
        int data;
        Node next;

        // Constructor to initialize the node
        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    // Function to swap two nodes in a linked list
    public void swapNodes(int x, int y) {
        // If x and y are the same, no swapping is required
        if (x == y)
            return;

        // Search for node x and keep track of its previous node
        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        // Search for node y and keep track of its previous node
        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either node x or node y is not present in the linked list, no swapping is
        // required
        if (currX == null || currY == null)
            return;

        // If node x is not the head of the linked list, update the link of its previous
        // node to node y
        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        // If node y is not the head of the linked list, update the link of its previous
        // node to node x
        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        // Swap the links of the nodes to swap their positions in the linked list
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    // Function to insert a node at the beginning of the linked list
    public void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    // Function to print the linked list
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {
        Solution3 llist = new Solution3();

        // Insert nodes at the beginning of the linked list
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.print("\n Linked list before ");
        llist.printList();

        // Swap nodes 4 and 3
        llist.swapNodes(4, 3);

        System.out.print("\n Linked list after ");
        llist.printList();
    }
}
