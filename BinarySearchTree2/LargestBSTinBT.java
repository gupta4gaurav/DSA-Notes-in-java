import java.util.*;

public class LargestBSTinBT {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static class Info { // Create a Helper Class for Information
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0; // Track the largest size

    public static Info largestBST(Node root) {
        if (root == null) {
            // Base case: an empty subtree is always a valid BST with size 0.
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Recursively calculate information for the left and right subtrees.
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);

        // Self
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check if the current subtree rooted at 'root' is a valid BST.
        if (root.data <= leftInfo.max || root.data >= rightInfo.min) {
            return new Info(false, size, min, max);
        }

        // If both left and right subtrees are valid BSTs, update maxBST if needed.
        if (leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        // If we reach this point, the current subtree is not a valid BST.
        return new Info(false, size, min, max);
    }

    public static void main(String args[]) {
        /*
        *               50
        *             /    \
        *          30       60
        *         /  \     /  \ 
        *        5   20   45    70
        *                      /  \
        *                    65    80
        *      
        *            Given Binary Tree
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        /*
        *             60
        *            /  \ 
        *          45    70
        *               /  \
        *             65    80  
        *    Expected Largest BST: Size = 5
        */

        // Calculate the information for the largest BST within the given binary tree.
        Info result = largestBST(root);
        System.out.println("Largest BST Size = " + maxBST);
    }
}