import java.util.*;

public class AreaInHistogram {
    public static void maxArea(int[] arr) {
        int maxArea = 0;
        int[] NxtSmallLeft = new int[arr.length];
        int[] NxtSmallRight = new int[arr.length];

        // Next Smaller Right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                // -1
                NxtSmallRight[i] = arr.length;
            } else {
                // Top
                NxtSmallRight[i] = s.peek();
            }
            s.push(i);
        }

        // Next Smaller left
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                // -1
                NxtSmallLeft[i] = -1;
            } else {
                // Top
                NxtSmallLeft[i] = s.peek();
            }
            s.push(i);
        }

        // Calculate the maximum area
        // Current Area : Width = j - i - 1 = nxtSmallerRight[i] - nxtSmallerLeft[i] - 1
        for (int i = 0; i < arr.length; i++) {
            int Height = arr[i];
            int Width = NxtSmallRight[i] - NxtSmallLeft[i] - 1;
            int CurrentArea = Height * Width;
            maxArea = Math.max(CurrentArea, maxArea);
        }

        System.out.println("Max Area in Histogram = " + maxArea);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 1, 5, 6, 2, 3 }; // Heights in Histogram
        maxArea(arr);
    }
}
