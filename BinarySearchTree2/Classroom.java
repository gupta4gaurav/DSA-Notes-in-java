import java.util.*;

public class Classroom {
    // Define the structure for tree nodes
    static class Node {
        int data;
        Node left, right;

        // Constructor for the Node
        public Node(int data) {
            this.left = null;    // Initialize left child as null
            this.right = null;   // Initialize right child as null
            this.data = data;    // Store data
        }
    }

    // Function to print nodes of BST in pre-order // create and print final tree 
    
    public static void preorder(Node root) {
        if (root == null) {
            return;    // If node is null, return without doing anything
        }
        System.out.print(root.data + " ");   // Print current node's data
        preorder(root.left);   // Recursively print left subtree
        preorder(root.right);  // Recursively print right subtree
    }

    // Function to construct a balanced BST from a sorted array
    public static Node createBST(int[] arr, int si, int end) {
        // Base condition: if start index is greater than end, return null
        if (si > end) {
            return null;
        }

        // Find the middle element to make it root of BST
        int mid = (si + end) / 2;

        // Create root node with middle element
        Node root = new Node(arr[mid]);

        // Recursively create left subtree from left half of array
        root.left = createBST(arr, si, mid - 1);
        // Recursively create right subtree from right half of array
        root.right = createBST(arr, mid + 1, end);

        return root;  // Return the created root node
    }

    public static void main(String[] args) {
        // Sorted array to create the BST
        int[] arr = { 3, 5, 6, 8, 10, 11, 12 };

        // Create BST using the sorted array
        Node root = createBST(arr, 0, arr.length - 1);

        // Print the BST in pre-order
        preorder(root);
    }
}
