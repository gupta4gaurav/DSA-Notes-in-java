import java.util.*;

public class BST {
    // Define the structure of the node of the binary search tree
    static class Node {
        int data; // node value
        Node left; // left child of node
        Node right; // right child of node

        Node(int data) { // node constructor
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to insert a value in the binary search tree
    public static Node insert(Node root, int val) {
        // If the tree is empty, create a new node and make it the root
        if (root == null) {
            root = new Node(val);
            return root;
        }

        // If the value to be inserted is less than the root's value, insert the value
        // in the left subtree.
        if (root.data > val) {
            // Recursively insert the node in the left subtree
            root.left = insert(root.left, val);
        } else {
            // Otherwise, insert the value in the right subtree.
            // Recursively insert the node in the right subtree
            root.right = insert(root.right, val);
        }
        return root; // return the updated root node
    }

    // Method to traverse the tree in an in-order way (left -> root -> right)
    public static void inorder(Node root) {
        // If the tree is empty, return
        if (root == null) {
            return;
        }
        // Recursively print the data of the nodes in an in-order way
        inorder(root.left); // traverse left subtree
        System.out.print(root.data + " "); // visit root node
        inorder(root.right); // traverse right subtree
    }

    // Function to search for a specific key in the Binary Search Tree (BST)
    public static boolean search(Node root, int key) {
        // Base case: if the root is null, it means the tree is empty or we've reached a
        // leaf node and didn't find the key
        if (root == null) {
            return false;
        }

        // If we find the key at the root, return true
        if (root.data == key) {
            return true;
        }

        // If the key is less than the value at root, we know it can only be in the left
        // subtree (since this is a BST) so we recursively search the left subtree
        if (root.data > key) {
            return search(root.left, key);
        } else {
            // If the key is more than the value at root, we know it can only be in the
            // right subtree (since this is a BST) so we recursively search the right
            // subtree
            return search(root.right, key);
        }
    }

    // Function to delete a node with a given value from the BST
    public static Node delete(Node root, int val) {

        // If the current node is null, return null (base case for recursion)
        if (root == null) {
            return null;
        }

        // If the value to be deleted is less than the current node's data,
        // move to the left subtree and try deleting there
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }

        // If the value to be deleted is greater than the current node's data,
        // move to the right subtree and try deleting there
        else if (root.data < val) {
            root.right = delete(root.right, val);
        }

        // If the current node's data matches the value to be deleted, handle the 3
        // possible deletion cases
        else {
            // Case 1: Node with only no child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node with only one child
            else if (root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }

            // Case 3: Node with two children
            // In this case, find the in-order successor of the node, copy its data, and
            // then delete the in-order successor
            else {
                Node IS = inorderSuccessor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    // Function to find the in-order successor (smallest node in the right subtree)
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        // int[] values = {5, 1, 3, 4, 2, 7}; // array of values to be inserted into the
        // tree

        int[] values = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null; // initially, the tree is empty

        // Insert each value from the array into the tree
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        // After all values have been inserted, print the in-order traversal of the tree
        // if(search(root, 8)){
        // System.out.println(true);
        // }else{
        // System.out.println(false);
        // }

        // Print the tree in in-order
        inorder(root);
        System.out.println();
        
        // Delete a node and then print the tree again to verify
        root = delete(root, 1);
        System.out.println();

        inorder(root);

    }
}
