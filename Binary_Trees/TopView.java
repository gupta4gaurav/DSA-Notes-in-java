import java.util.*;

public class TopView {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        Node node;
        int hd;

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {

        if (root == null) {
            return;
        }

        // Level Order Traversal
        Queue<Info> q = new LinkedList<>();

        // HashMap to store the nodes with their horizontal distances
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0; // Variables to track the minimum and maximum horizontal distances

        // Add the root node with horizontal distance 0 to the queue
        q.add(new Info(root, 0));
        q.add(null); // Add a marker to indicate the end of a level

        while (!q.isEmpty()) {
            Info curr = q.remove();

            if (curr == null) {
                // If the current node is null, it indicates the end of a level

                if (q.isEmpty()) {
                    break; // If the queue is empty, we have processed all nodes
                } else {
                    q.add(null); // Add a marker for the next level
                }
            } else {
                // If the current node is not null

                if (!map.containsKey(curr.hd)) {
                    // If the horizontal distance is encountered for the first time,
                    // add the node to the map
                    map.put(curr.hd, curr.node);
                }

                // Enqueue the left child with a reduced horizontal distance (hd - 1)
                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1); // Update the minimum horizontal distance
                }

                // Enqueue the right child with an increased horizontal distance (hd + 1)
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1); // Update the maximum horizontal distance
                }
            }
        }

        // Print the nodes in the top view from the minimum to the maximum horizontal distance
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
         *      1
         *     / \
         *    2   3
         *   / \ / \
         *  4  5 6  7
         * 
         * expected output : 4 2 1 3 7
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        /*
         * 1
         * / \
         * 2 3
         * \
         * 4
         * \
         * 5
         * \
         * 6
         * 
         * expected output : 2 1 3 6
         */
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.right = new Node(4);
        root2.left.right.right = new Node(5);
        root2.left.right.right.right = new Node(6);

        topView(root);
    }
}
