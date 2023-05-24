import java.util.*;

public class Question4 {
    // Function to calculate the stock span
    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stocks.length; i++) {
            int currPrice = stocks[i];

            // Pop elements from the stack as long as the current price is greater than the
            // price of the top of the stack
            while (!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }

            // If the stack is empty, then the span is the number of days between the
            // current day and the first day
            if (s.isEmpty()) {
                span[i] = i + 1;
            }
            // If the stack is not empty, then the span is the number of days between the
            // current day and the previous day where the price was higher than the current
            // day
            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static void main(String[] args) {
        int[] stocks = { 100, 80, 60, 70, 60, 85, 100 };
        int[] span = new int[stocks.length];

        // Calculate the stock span
        stockSpan(stocks, span);

        // Print the stock span for each day
        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i] + " ");
        }
    }
}