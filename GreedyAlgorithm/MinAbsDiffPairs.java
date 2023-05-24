import java.util.*;

public class MinAbsDiffPairs {
    public static void main(String[] args) {
        // Define two input arrays A and B
        int[] A = { 4, 1, 8, 7 };
        int[] B = { 2, 3, 6, 5 };

        // Sort the arrays A and B in ascending order
        Arrays.sort(A);
        Arrays.sort(B);


        // Initialize a variable to store the minimum absolute difference
        int minDiff = 0;

        // Iterate over the arrays A and B
        for(int i = 0; i < A.length; i++){
            // Calculate the absolute difference between the current elements of A and B
            int absDiff = Math.abs(A[i] - B[i]);

            // Add the absolute difference to the minimum difference
            minDiff += absDiff;

        }
        // Print the minimum absolute difference of pairs
        System.out.println("Minimum Absolute difference of Pairs = " + minDiff);
    }
}
