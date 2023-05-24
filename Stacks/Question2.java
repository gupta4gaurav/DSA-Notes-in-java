import java.util.*;

public class Question2 {
    // Function to reverse a string using stack
    public static String reverseStr(String str) {
        // Create a stack of characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the string onto the stack
        int idx = 0;
        while (idx < str.length()) {
            stack.push(str.charAt(idx));
            idx++;
        }

        // Pop each character from the stack to get the reversed string
        StringBuilder result = new StringBuilder("");
        while (!stack.isEmpty()) {
            char curr = stack.pop();
            result.append(curr);
        }
        str = result.toString();

        // Return the reversed string
        return str;
    }

    public static void main(String[] args) {
        // Test the reverseStr function
        String str = "Gaurav Gupta";
        System.out.println(reverseStr(str));
    }
}
