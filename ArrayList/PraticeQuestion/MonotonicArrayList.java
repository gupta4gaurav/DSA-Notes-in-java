import java.util.ArrayList;

public class MonotonicArrayList {
    // This function checks if the given ArrayList is monotonic or not
    public static boolean isMonotonic(ArrayList<Integer> list) {
        boolean inc = true; // Flag for increasing order
        boolean dec = true; // Flag for decreasing order
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) { // If not in increasing order
                inc = false;
            }
            if (list.get(i) < list.get(i + 1)) { // If not in decreasing order
                dec = false;
            }
        }
        // If either inc flag or dec flag is true, then it is monotonic
        return inc || dec;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(4);
        System.out.println(isMonotonic(list)); // Expected output: true
    }

}
