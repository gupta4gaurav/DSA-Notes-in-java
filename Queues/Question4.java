import java.util.*;

public class Question4 {
    // Function to print the first non-repeating character in each prefix of a
    // string
    public static void printNonRepeating(String str) {
        int[] freq = new int[26]; // Array to store the frequency of characters (a-z)
        Queue<Character> q = new LinkedList<>(); // Queue to maintain the order of characters

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch); // Add the character to the queue
            freq[ch - 'a']++; // Increment the frequency of the character

            // Remove characters from the front of the queue until a non-repeating character
            // is found
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            // Print the first non-repeating character in the current prefix
            if (q.isEmpty()) {
                System.out.print(-1 + " "); // No non-repeating character found
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println(); // Print a new line after processing the string
    }

    public static void main(String[] args) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}
