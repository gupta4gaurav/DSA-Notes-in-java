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

    public static int diameter2(Node root) { // Approach 1
        if (root == null) {
            return 0;
        }

        // Calculate the diameter recursively for the left and right subtrees
        int leftDiam = diameter2(root.left);
        int leftHt = height(root.left);
        int rightDiam = diameter2(root.right);
        int rightHt = height(root.right);

        // Calculate the diameter passing through the current node
        int selfDiam = leftHt + rightHt + 1;

        // Return the maximum of the three diameters
        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        // Calculate the diameter and height recursively for the left and right subtrees
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        // Calculate the diameter passing through the current node
        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        // Return the diameter and height information in an Info object
        return new Info(diam, ht);
    }

    

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        // Recursively check if the nodes and their children are identical
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;
    }

    public static boolean isSubTree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        // If the current node is the same as the subRoot, check if it's identical
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // Recursively check if the subRoot is a subtree of the left or right subtree
        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
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

        /*
        *    2
        *   / \
        *  4   5
        */

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubTree(root, subRoot));
    }
}
