import java.util.Collections;
import java.util.ArrayList;

public class LonelyNumbers {
    public static ArrayList<Integer> FindLonelyNums(ArrayList<Integer> nums) {
        Collections.sort(nums); // Sort the input list in ascending order
        ArrayList<Integer> list = new ArrayList<>(); // Initialize a new ArrayList to hold the lonely numbers

        // Loop through the sorted input list, skipping the first and last elements
        for (int i = 1; i < nums.size() - 1; i++) {
            // Check if the current number is lonely by comparing it to its adjacent numbers
            if (nums.get(i - 1) + 1 < nums.get(i) && nums.get(i) + 1 < nums.get(i + 1)) {
                list.add(nums.get(i)); // If the number is lonely, add it to the output list
            }
        }

        // Check the first and last elements separately in case they are lonely
        if (nums.size() == 1) {
            list.add(nums.get(0));
        }
        if (nums.size() > 1) {
            if (nums.get(0) + 1 < nums.get(1)) {
                list.add(nums.get(0));
            }
            if (nums.get(nums.size() - 2) + 1 < nums.get(nums.size() - 1)) {
                list.add(nums.get(nums.size() - 1));
            }
        }

        return list; // Return the list of lonely numbers
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        System.out.println(FindLonelyNums(list));
    }
}
