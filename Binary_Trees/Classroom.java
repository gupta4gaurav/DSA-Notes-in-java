import java.util.*;

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

    public static void KLevel(Node root, int level, int k) {
        // Base case: If the current node is null, return
        if (root == null) {
            return;
        }

        // If the current level matches the target level (k),
        // print the data of the current node and return
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        // If the current level is not the target level (k),
        // recursively call the function for the left and right subtrees
        // with the level increased by 1 (moving down the tree)
        KLevel(root.left, level + 1, k);
        KLevel(root.right, level + 1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false; // If the root is null, return false as the node n cannot be found in this
                          // subtree.
        }

        path.add(root); // Add the current node to the path.

        if (root.data == n) {
            return true; // If the current node contains the data n, we found the path to the node n, so
                         // return true.
        }

        // Recursively search for node n in the left and right subtrees.
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // If either the left or right subtree has found the node n, return true.
        if (foundLeft || foundRight) {
            return true;
        }

        // If the node n is not found in the current subtree, remove the current node
        // from the path and return false.
        path.remove(root);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        // Find the paths from the root to the nodes n1 and n2.
        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // Traverse both paths and find the last common ancestor (LCA) of nodes n1 and
        // n2.
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break; // Stop when the paths diverge, i.e., the last common node is found.
            }
        }

        // The LCA is the node just before the point of divergence in the paths, i.e.,
        // i-1th node.
        Node lca = path1.get(i - 1);

        return lca; // Return the last common ancestor of nodes n1 and n2.
    }

    // Function to find the Lowest Common Ancestor (LCA) for the given two nodes in
    // a binary tree.
    public static Node lca2(Node root, int n1, int n2) {
        // If the current node is null or it matches one of the target nodes (n1 or n2),
        // we return the current node. This is our base case for the recursion.
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        // Recursively find the LCA in the left and right subtrees of the current node.
        Node leftLCA = lca2(root.left, n1, n2);
        Node rightLCA = lca2(root.right, n1, n2);

        // If one of the LCAs is null, it indicates that one of the target nodes is not
        // in that subtree.
        // So, we return the non-null LCA which is in the other subtree.
        if (rightLCA == null) {
            return leftLCA; // The right subtree doesn't contain either of the nodes. Return the left LCA.
        }

        if (leftLCA == null) {
            return rightLCA; // The left subtree doesn't contain either of the nodes. Return the right LCA.
        }

        // If both left and right LCAs are not null, it means the target nodes
        // are located in different subtrees, so the current node is the LCA.
        return root;
    }

    public static int lcaDist(Node root, int n) {
        // If the current node is null, we return -1 indicating the node n was not found
        // in this path.
        if (root == null) {
            return -1;
        }

        // If the current node is the target node, we return 0 indicating we've found
        // the node.
        if (root.data == n) {
            return 0;
        }

        // We recursively search for the node in the left and right subtrees.
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        // If the node was not found in either subtree, we return -1.
        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        // If the node was found in the right subtree, we return the distance
        // incremented by one.
        else if (leftDist == -1) {
            return rightDist + 1;
        }
        // If the node was found in the left subtree, we return the distance incremented
        // by one.
        else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        // First, find the Lowest Common Ancestor (LCA) of the two nodes.
        Node lca = lca2(root, n1, n2);
        // Then, calculate the distance from the LCA to each of the two nodes.
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        // The minimum distance between the two nodes is the sum of these two distances.
        return dist1 + dist2;
    }

    public static int KAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        
        if(root.data == n){
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        
        int max = Math.max(leftDist, rightDist);

        if(max + 1 == k ){
            System.out.println(root.data);
        }
        return max + 1;
    }


    // Function to transform a binary tree such that every node contains the sum of
    // its children's data plus the data of all descendants.
    public static int transform(Node root) {
        // If the node is null, we return 0.
        if (root == null) {
            return 0;
        }

        // Recursively calculate the sums for the left and right subtrees.
        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        // Keep a copy of the original data of the current node.
        int data = root.data;

        // Calculate the new data for the current node. If a child node is null, its
        // data is treated as 0.
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        // Update the current node's data to be the sum of its children's data and the
        // data of all descendants.
        root.data = newLeft + leftChild + newRight + rightChild;

        // Return the original data of the current node.
        return data;
    }

    // Function to print the pre-order traversal of the binary tree.
    public static void preorder(Node root) {
        // If the node is null, we return.
        if (root == null) {
            return;
        }

        // Print the data of the current node.
        System.out.print(root.data + " ");

        // Recursively print the data of the left and right subtrees.
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
         *   1
         *  / \
         *  2  3
         * / \ / \
         * 4 5 6 7
         * 
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         * 2
         * / \
         * 4 5
         */

        // Node subRoot = new Node(2);
        // subRoot.left = new Node(4);
        // subRoot.right = new Node(5);

        // System.out.println(isSubTree(root, subRoot));
        // int k = 3;
        // KLevel(root, 1, k);

        // int n1 = 4, n2 = 6;
        // // System.out.println(lca2(root, n1, n2).data);
        // System.out.println(minDist(root, n1, n2));

        // int n = 5, k = 1;
        // KAncestor(root, n, k);

        transform(root);
        preorder(root);
    }
}
