import java.util.*;

public class isValidParentheses {
    // Function to check if the parentheses in a string are valid
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') { // Opening parentheses
                s.push(ch);
            } else { // Closing parentheses
                if (s.isEmpty()) {
                    return false; // No corresponding opening parentheses found
                }
                if ((s.peek() == '(' && ch == ')') // Matching opening and closing parentheses
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop(); // Pop the opening parentheses from the stack
                } else {
                    return false; // Mismatched opening and closing parentheses
                }
            }
        }

        if (s.isEmpty()) {
            return true; // All parentheses are matched
        } else {
            return false; // Some opening parentheses are unmatched
        }
    }

    public static void main(String[] args) {
        String str = "({})[]"; // String with valid parentheses
        System.out.println(isValid(str));
    }
}
