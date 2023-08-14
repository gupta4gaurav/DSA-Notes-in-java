public class Classroom {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null; // Initialize the left and right children to null
        }
    }

    // Pre-order traversal of the tree (root -> left -> right)
    public static void preOrder(Node root) {
        if (root == null) {
            return; // Base case: if the node is null, return
        }

        System.out.print(root.data + " "); // Print the current node's data
        preOrder(root.left); // Traverse left subtree
        preOrder(root.right); // Traverse right subtree
    }

    // Method to mirror a Binary Tree
    public static Node mirrorBST(Node root) {
        if (root == null) {
            return null; // Base case: if the node is null, return null
        }

        Node mirrorLeft = mirrorBST(root.left); // Mirror the left subtree
        Node mirrorRight = mirrorBST(root.right); // Mirror the right subtree

        root.left = mirrorRight; // Swap left child with mirrored right subtree
        root.right = mirrorLeft; // Swap right child with mirrored left subtree
        return root; // Return the current root
    }

    public static void main(String[] args) {
        // Construct the original tree
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        // Mirror the tree using the mirrorBST method
        root = mirrorBST(root);

        // Print the mirrored tree using a pre-order traversal
        preOrder(root);
    }
}
