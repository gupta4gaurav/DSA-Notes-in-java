import java.util.*;

public class Classroom1 {
    static class Node {
        int data;
        Node right, left;

        public Node(int data) {
            this.right = null;
            this.left = null;
            this.data = data;
        }
    }

    // Function to perform a preorder traversal and print the BST
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Function to balance an unbalanced BST
    public static Node balanceBST(Node root) { // O(n)

        // Step 1: Create a sorted inorder sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);

        // Step 2: Convert the sorted inorder sequence into a balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    // Step 1 Part 2: Perform an inorder traversal and populate the inorder list
    public static void getInOrder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInOrder(root.left, inorder);
        inorder.add(root.data);
        getInOrder(root.right, inorder);
    }

    // Step 2: Convert the sorted inorder sequence into a balanced BST
    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static void main(String args[]) {
        /*
         *          8
         *         / \
         *        6   10
         *       /      \
         *      5       11
         *     /          \
         *    3            12
         * 
         *      Given BST
         */

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);

        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);

        /*
         *           8
         *         /  \
         *        5   11
         *       / \  / \
         *      3  6 10  12
         *      
         *      Desired BST
         */

        root = balanceBST(root); // Balance the BST
        preorder(root); // Print the elements of the balanced BST in preorder
    }
}
