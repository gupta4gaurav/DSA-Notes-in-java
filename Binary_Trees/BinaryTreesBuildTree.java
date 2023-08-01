import java.util.*;
import java.util.LinkedList;

public class BinaryTreesBuildTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTrees {
        static int idx = -1;

        public Node buildTree(int[] nodes) {
            idx++; // Increment the index

            // If the current node value is -1, it represents a null node
            // Return null to indicate the absence of a node
            if (nodes[idx] == -1) {
                return null;
            }

            // Create a new node with the current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build the left and right subtrees
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode; // Return the constructed node
        }

        public void preOrder(Node root) {
            if (root == null) {
                System.out.print("-1" + " ");
                return;
            }
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }

        public void postOrder(Node root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");

        }

        public void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();

                if (currNode == null) {
                    System.out.println(); // Print a new line to indicate the end of a level

                    if (q.isEmpty()) {
                        break; // If the queue is empty, we have reached the end of the binary tree
                    } else {
                        q.add(null); // Add a null node to indicate the end of the current level
                    }
                } else {
                    System.out.print(currNode.data + " "); // Print the data of the current node

                    if (currNode.left != null) {
                        q.add(currNode.left); // Add the left child to the queue
                    }

                    if (currNode.right != null) {
                        q.add(currNode.right); // Add the right child to the queue
                    }
                }
            }

        }
        

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 }; // data

        BinaryTrees trees = new BinaryTrees(); // Create an instance of BinaryTrees
        Node root = trees.buildTree(nodes); // Build the tree from the nodes array
        // System.out.println(root.data); // Output the value of the root node (1 in
        // this case)

        // trees.postOrder(root);
        trees.levelOrder(root);
    }
}
