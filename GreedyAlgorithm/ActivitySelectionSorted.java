import java.util.*;

public class ActivitySelectionSorted {

    public static void main(String[] args) { // O(n)
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // Assuming End times Sorted

        // End time basis sorted
        int maximumActivity = 0; // Variable to store the maximum number of activities
        ArrayList<Integer> ans = new ArrayList<>(); // To store activity Index

        // First activity - will be completed fastest, so we can schedule more
        // activities afterward.
        maximumActivity = 1; // Assigning value 1.
        ans.add(0); // Adding the index of the first activity to the answer list
        int lastEnd = end[0]; // End Time of the first activity - Initializing the end time of the last chosen
                              // activity

        // Iterate over the remaining activities
        for (int i = 1; i < end.length; i++) {
            if (start[i] >= lastEnd) {
                // If the start time of the current activity is greater than or equal to the end
                // time of the last chosen activity,
                // then this activity can be scheduled without any conflicts.
                maximumActivity++;
                ans.add(i); // Adding the index of the current activity to the answer list
                lastEnd = end[i]; // Update the end time of the last chosen activity
            }
        }
        System.out.println("Max Activities = " + maximumActivity);

        // Printing the selected activities
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
    }
}
