import java.util.*;

public class NextGreater {
    public static void main(String[] args) {
        // Defining input array
        int[] arr = { 9, 6, 2, 3, 1, 8 };

        // Initializing an empty stack and an array for storing next greater element
        Stack<Integer> s = new Stack<>();
        int[] nxtGreater = new int[arr.length];

        // Loop through the array in reverse order
        for (int i = arr.length - 1; i >= 0; i--) {
            // Step - 1 While Loop: pop elements from stack till stack top element is
            // smaller than or equal to the current array element
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }

            // Step - 2 if-else: if stack is empty, then the current element has no greater
            // element to its right, else top element of stack is the next greater element
            // of current element
            if (s.isEmpty()) {
                nxtGreater[i] = -1;
            } else {
                nxtGreater[i] = arr[s.peek()];
            }

            // Push the current element index into the stack ̰
            s.push(i);
        }

        // Printing the array containing next greater element for each element of the
        // input array
        for (int i = 0; i < nxtGreater.length; i++) {
            System.out.print(nxtGreater[i] + " ");
        }
        System.out.println();
    }
}