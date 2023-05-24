import java.util.ArrayList;

public class SumPair_2 {

    // Function to find if there exists a pair of elements whose sum equals target
    public static boolean findPairSum2(ArrayList<Integer> list, int target) {
        int BP = -1; // Breaking Point or Pivot
        int n = list.size();

        // Find the pivot element (the point where the list is rotated)
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                BP = i;
                break;
            }
        }

        int lP = BP + 1; // Left Pointer || Smallest Element
        int rP = BP; // Right Pointer || Largest Element

        // Loop through the list until left and right pointers meet
        while (lP != rP) {
            // Case - 1: If sum of left and right element is equal to target
            if (list.get(lP) + list.get(rP) == target) {
                return true;
            }

            // Case - 2: If sum of left and right element is less than target
            if (list.get(lP) + list.get(rP) < target) {
                lP = (lP + 1) % n; // Move the left pointer to next element
            }
            // Case - 3: If sum of left and right element is greater than target
            if (list.get(lP) + list.get(rP) > target) {
                rP = (n + rP - 1) % n; // Move the right pointer to previous element
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        // List is sorted and rotated
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target = 16;
        System.out.println(findPairSum2(list, 16)); // Output: true
    }
}
