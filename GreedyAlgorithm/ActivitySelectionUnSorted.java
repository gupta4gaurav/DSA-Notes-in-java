import java.util.*;

public class ActivitySelectionUnSorted {

    public static void main(String[] args) { // O(n)
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 }; // Assuming End times UnSorted

        // Sorting
        int[][] activities = new int[start.length][3]; // 2D Arrays
        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i; // Assigning the index of the activity
            activities[i][1] = start[i]; // Assigning the start time of the activity
            activities[i][2] = end[i]; // Assigning the end time of the activity
        }

        // 2D Sorting Function
        // Lambda Function -> shortform => Comparator.comparingDouble(o -> o[2])
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // End time basis sorted
        int maximumActivity = 0; // Variable to store the maximum number of activities
        ArrayList<Integer> ans = new ArrayList<>(); // To store activity Index

        maximumActivity = 1;
        ans.add(activities[0][0]); // Adding the index of the first activity to the answer list
        int lastEnd = activities[0][2]; // End Time of the first activity

        // Iterate over the remaining activities
        for (int i = 1; i < end.length; i++) {
            if (activities[i][1] >= lastEnd) {
                // If the start time of the current activity is greater than or equal to the end
                // time of the last chosen activity,
                // then this activity can be scheduled without any conflicts.

                maximumActivity++;
                ans.add(activities[i][0]); // Adding the index of the current activity to the answer list
                lastEnd = activities[i][2]; // Update the end time of the last chosen activity
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
