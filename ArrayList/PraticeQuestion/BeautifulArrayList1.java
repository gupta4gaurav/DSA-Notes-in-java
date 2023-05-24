import java.util.ArrayList;

public class BeautifulArrayList1 { // using iteration
    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1); // Initialize the beautiful array with 1

        // Loop through all numbers from 2 to n and generate the beautiful array
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();

            // Add all odd numbers in the current beautiful array
            for (Integer e : ans) {
                if (e * 2 - 1 <= n) {
                    temp.add(e * 2 - 1);
                }
            }

            // Add all even numbers in the current beautiful array
            for (Integer e : ans) {
                if (e * 2 <= n) {
                    temp.add(e * 2);
                }
            }

            ans = temp; // Replace the current beautiful array with the new one
        }

        return ans; // Return the final beautiful array
    }

    public static void main(String[] args) {
        System.out.println(beautifulArray(4)); // Output: [1, 3, 2, 4]
        System.out.println(beautifulArray(5)); // Output: [1, 3, 5, 2, 4]
    }
}
