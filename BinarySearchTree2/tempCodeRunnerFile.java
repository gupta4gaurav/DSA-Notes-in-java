public class AVLTrees {
    // Node class to represent each node in the AVL tree
    static class Node {
        int data; // The data stored in the node
        int height; // Height of the node
        Node left, right; // Left and right child nodes

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            height = 1; // New node is initially added as a leaf, so height is 1
            left = right = null;
        }
    }

    // The root of the AVL tree
    public static Node root;

    // Function to calculate the height of a node
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // Function to find the maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Function to insert a key into the AVL tree
    public static Node insert(Node root, int key) {
        // Step 1: Perform standard BST insertion
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate keys are not allowed in AVL trees
        }

        // Step 2: Update the height of the current node
        root.height = 1 + max(height(root.left), height(root.right));

        // Step 3: Get the balance factor of the current node
        int balance = getBalance(root);

        // Step 4: Perform necessary rotations based on the balance factor

        // Left Left Case (LL)
        if (balance > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // Right Right Case (RR)
        if (balance < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // Left Right Case (LR)
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case (RL)
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // If the tree remains balanced, return the current root
        return root;
    }

    // Right rotate a subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform the rotation using 3 nodes
        x.right = y;
        y.left = T2;

        // Update the heights of the rotated nodes
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // x is the new root of the subtree
        return x;
    }

    // Left rotate a subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform the rotation using 3 nodes
        y.left = x;
        x.right = T2;

        // Update the heights of the rotated nodes
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // y is the new root of the subtree
        return y;
    }

    // Get the balance factor of a node
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Perform a preorder traversal of the AVL tree
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " "); // Print the data of the current node
        preorder(root.left); // Recursively traverse the left subtree
        preorder(root.right); // Recursively traverse the right subtree
    }

    public static void main(String[] args) {
        // Create an empty AVL tree

        // Insert some elements into the AVL tree
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /* The AVL Tree after insertions:
        *             30
        *            /  \
        *           20  40
        *          / \   \
        *         10  25  50
        */

        // Perform a preorder traversal of the AVL tree
        System.out.println("Preorder Traversal of AVL Tree:");
        preorder(root);
    }
}
