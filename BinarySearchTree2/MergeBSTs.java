import java.util.*;

public class MergeBSTs {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Helper function to get the inorder traversal of a BST
    public static void getInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);
    }

    // Helper function to create a balanced BST from a sorted array
    public static Node createBST(ArrayList<Integer> arr, int st, int end){ // Create Balanced BST
        if(st > end){
            return null;
        }

        int mid = (st + end) / 2;
        Node root = new Node(arr.get(mid));

        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        
        return root;
    }

    // Function to merge two BSTs into one balanced BST
    public static Node mergeBSTs(Node root1, Node root2){
        // Step - 1: Get inorder traversal of BST1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);
        
        // Step - 2: Get inorder traversal of BST2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Step - 3: Merge the two sorted arrays into one
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i < arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }

        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }

        // Step 4: Create a balanced BST from the merged sorted array
        return createBST(finalArr, 0, finalArr.size() - 1 );
    }

    public static void main(String args[]) {
        /*     
        *          2     
        *         / \    
        *        1   4   
        *        BST1
        */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        
        /*     
        *          9    
        *         / \    
        *        3   12   
        *        BST2
        */
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        /* Two possible expected balanced BSTs can be formed:
        * 
        * First Balanced BST:
        *             4
        *            /  \ 
        *           2    9
        *          / \    \
        *         1   3   12 
        *    
        * Second Balanced BST:
        *              3
        *            /   \ 
        *           1      9
        *            \    / \
        *             2  4  12 
        *        
        * The final answer is the second BST.
        */

        Node root = mergeBSTs(root1, root2);
        preorder(root);

        // Time Complexity: O(n + m), where n and m are the sizes of the two input BSTs
    }
}