import java.util.*;

public class CheckDuplicateParentheses {
    // Function to check for duplicate parentheses
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Closing parentheses
            if (ch == ')') {
                int count = 0;
                // Pop all elements until an opening parentheses '(' is encountered
                while (s.pop() != '(') {
                    count++;
                }
                // If there are no elements between the opening and closing parentheses, it is a
                // duplicate
                if (count < 1) {
                    return true; // Duplicate
                }
            } else {
                // Opening parentheses, push onto the stack
                s.push(ch);
            }
        }
        return false; // No duplicate parentheses found
    }

    public static void main(String[] args) {
        String str = "((a+b))"; // Contains duplicate parentheses
        String str2 = "(a-b)"; // No duplicate parentheses
        System.out.println(isDuplicate(str)); // Prints true
        System.out.println(isDuplicate(str2)); // Prints false
    }
}
