import java.util.*;

public class MaxLengthChainPairs {
    public static void main(String[] args) {
        // Define the input pairs as a 2D array
        int[][] pairs = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        // Sort the pairs based on the second element in each pair using a comparator
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        // Initialize variables for chain length and chain end
        int chainLength = 1;
        int chainEnd = pairs[0][1]; // Initialize the chain end as the end of the first pair

        // Iterate over the sorted pairs
        for (int i = 1; i < pairs.length; i++) {
            // If the start of the current pair is greater than the chain end
            if (pairs[i][0] > chainEnd) {
                // Increment the chain length
                chainLength++;
                // Update the chain end to the end of the current pair
                chainEnd = pairs[i][1];
            }
        }

        // Print the maximum length of the chain
        System.out.println("Max Length of Chain = " + chainLength);
    }
}
