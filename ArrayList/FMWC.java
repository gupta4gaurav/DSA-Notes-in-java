import java.util.ArrayList;

public class FMWC {
    // Optimized ( 2 pointer) - O(n)
    public static int findMaxWaterContainer(ArrayList<Integer> height) {
        int leftPtr = 0, rightPtr = height.size() - 1;
        int maxWater = 0;
        while (leftPtr < rightPtr) {
            int ht = Math.min(height.get(leftPtr), height.get(rightPtr)); // find height of container
            int width = rightPtr - leftPtr; // find width of container
            int currWater = ht * width; // calculate current water level
            maxWater = Math.max(maxWater, currWater); // update max water level

            // Move Pointer to the higher side
            if (height.get(leftPtr) < height.get(rightPtr)) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }
        return maxWater;
    }

    public static void main(String args[]) {
        // Creating an ArrayList of heights
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        // Find the maximum water container using 2 pointer approach
        System.out.println(findMaxWaterContainer(height));
    }
}
