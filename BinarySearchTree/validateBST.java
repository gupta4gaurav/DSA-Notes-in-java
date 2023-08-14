import java.util.ArrayList;

public class validateBST {

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

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) { // go to left subtree
            root.left = insert(root.left, val);
        } else { // go to right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean isvalidBST(Node root, Node rightMin, Node leftMax){
        if(root == null){
            return true;
        }
        if(leftMax != null && root.data <= leftMax.data){
            return false;
        }
        if(rightMin != null && root.data >= rightMin.data){
            return false;
        }

        return isvalidBST(root.left, root, leftMax) && isvalidBST(root.right, rightMin, root);
    }

    public static void main(String args[]) {
        Node root = null;
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        if(isvalidBST(root, null, null)){
            System.out.println("valid");
        }else{
            System.out.println("not Valid");
        }
    }
}
