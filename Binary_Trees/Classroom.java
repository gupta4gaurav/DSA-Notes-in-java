public class Classroom {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        // Recursively calculate the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Return the maximum height plus 1 for the current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int countNode(Node root) {
        if (root == null) {
            return 0;
        }

        // Recursively count the nodes in the left and right subtrees
        int leftNodeCount = countNode(root.left);
        int rightNodeCount = countNode(root.right);

        // Return the total count of nodes including the current node
        return 1 + leftNodeCount + rightNodeCount;
    }

    public static int sumNode(Node root) {
        if (root == null) {
            return 0;
        }

        // Recursively calculate the sum of node values in the left and right subtrees
        int leftNodeSum = sumNode(root.left);
        int rightNodeSum = sumNode(root.right);

        // Return the sum of node values including the current node
        return root.data + leftNodeSum + rightNodeSum;
    }

    public static void main(String[] args) {
        /*
         *       1
         *     /   \
         *    2     3
         *   / \   / \
         *  4   5 6   7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // System.out.println(height(root)); // Output the height of the binary tree
        
        System.out.println(sumNode(root)); // Output the sum of node values
    }
}
