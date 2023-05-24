import java.util.ArrayList;

public class BeautifulArrayList2 {

    public static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        divideConquer(1, 1, res, n); // Call the divide-and-conquer method
        return res;
    }

    private static void divideConquer(int start, int increment, ArrayList<Integer> res, int n) {
        if (start + increment > n) { // If the current start index plus the increment is greater than n
            res.add(start); // Add the current start index to the result list
            return; // Exit the recursive function
        }

        // Recursively call the divide-and-conquer method with the new start and
        // increment values
        divideConquer(start, 2 * increment, res, n);
        divideConquer(start + increment, 2 * increment, res, n);
    }

    public static void main(String[] args) {
        System.out.println(beautifulArray(4)); // Output: [1, 3, 2, 4]
    }
}
