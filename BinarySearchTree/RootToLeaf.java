import java.util.*;
public class RootToLeaf {
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

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i)+ " ");
        }
        System.out.println();
    }

    public static void printRootToLeaf(Node root, ArrayList<Integer> path ){
        if(root == null){
            return;
        }

        path.add(root.data);
        if(root.right == null && root.left == null){
            printPath(path);
        }
        printRootToLeaf(root.left, path);
        printRootToLeaf(root.right, path);

        path.remove(path.size() - 1);
    }

    

    public static void main(String args[]) {
        Node root = null;
        int values[] = { 8, 5, 3, 6, 10, 11, 14 };
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        printRootToLeaf(root, new ArrayList<>());
    }
}
