public class Permutations {

    // Recursive method to find all permutations of a given string
    public static void findSubString(String str, String ans) {

        // Base Case: if the string is empty, print the current permutation and return
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }

        // Recursive Case:
        // Iterate through the string and pick each character as the first character
        // of the permutation, then recursively find the permutations of the remaining
        // characters and add the picked character to the permutation
        for (int i = 0; i < str.length(); i++) {
            char pickedChar = str.charAt(i);
            String restStr = str.substring(0, i) + str.substring(i + 1, str.length());
            findSubString(restStr, ans + pickedChar);
        }
    }

    // Main method
    public static void main(String[] args) {
        // Initialize a string
        String str = "abc";

        // Call the recursive method findSubString with the string and an empty string
        // as the initial permutation
        findSubString(str, "");
        System.out.println();
    }
}
