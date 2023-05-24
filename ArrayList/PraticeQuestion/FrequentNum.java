import java.util.ArrayList;

public class FrequentNum {
    public static int mostFrequent(ArrayList<Integer> nums, int key) {
        int[] result = new int[1000]; // Initialize an array of size 1000 to hold frequency of numbers
        
        // Loop through the input list and count the frequency of the key value
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) == key) {
                result[nums.get(i + 1) - 1]++;
            }
        }

        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer value
        int ans = 0; // Initialize ans to zero

        // Loop through the frequency array to find the most frequent number
        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i]; // Update max to the current frequency if it's greater than the previous max
                ans = i + 1; // Update ans to the current number if it's the most frequent so far
            }
        }

        return ans; // Return the most frequent number
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3);
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        int key = 3;
        System.out.println(mostFrequent(nums, key));
    }

}

