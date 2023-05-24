import java.util.*;

public class FractionalKnapsack {

    public static void main(String[] args) {
        int[] val = { 60, 100, 120 }; // Values of the items
        int[] weight = { 10, 20, 30 }; // Weights of the items
        int W = 50; // Total weight capacity of the knapsack

        // Create a double data type 2D array "ratio"
        // 0th column => index of the item
        // 1st column => value-to-weight ratio of the item
        double[][] ratio = new double[val.length][2];

        // Calculate and assign the value-to-weight ratios for each item
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; // Assign the index of the item
            ratio[i][1] = val[i] / (double) weight[i]; // Calculate the ratio
        }

        // Sort the "ratio" array in ascending order based on the value-to-weight ratios
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity = W; // Initialize the remaining capacity of the knapsack
        int finalVal = 0; // Initialize the final value of the knapsack

        // Iterate over the items in descending order of their value-to-weight ratios
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0]; // Get the index of the item
            if (capacity >= weight[idx]) { // If the item can be included fully
                finalVal += val[idx]; // Add the value of the item to the final value
                capacity -= weight[idx]; // Reduce the capacity of the knapsack
            } else {
                // If the item cannot be included fully, include a fractional part of it
                finalVal += (ratio[i][1] * capacity); // Add the fractional value to the final value
                capacity = 0; // The knapsack is full now, so set the capacity to 0
                break; // No more items can be included, so break the loop
            }
        }

        System.out.println("Final Value = " + finalVal); // Print the final value of the knapsack
    }
}
