import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>(); // Create a queue to store the binary numbers
        q.add("1"); // Add the initial binary number "1" to the queue

        while (n > 0) { // Perform the following steps n times
            String s1 = q.peek(); // Peek at the front of the queue and store it in s1
            q.remove(); // Remove the front element from the queue
            System.out.println(s1); // Print the binary number s1
            String s2 = s1; // Store the value of s1 in s2
            q.add(s1 + "0"); // Append "0" to s1 and add it back to the queue
            q.add(s2 + "1"); // Append "1" to s2 and add it back to the queue
            n--; // Decrement n to control the number of iterations
        }
    }

    public static void main(String[] args) {
        int n = 10; // Define the range of numbers for generating binary numbers
        generatePrintBinary(n); // Call the generatePrintBinary function with n as an argument
    }
}
