import java.util.*;

public class Chocolate {
    public static void main(String[] args) {
        int n = 4, m = 6;

        Integer[] costVer = { 2, 1, 3, 1, 4 }; // m - 1
        Integer[] costHor = { 4, 1, 2 }; // n - 1

        Arrays.sort(costVer, Collections.reverseOrder()); // Sort the vertical cuts' costs in descending order
        Arrays.sort(costHor, Collections.reverseOrder()); // Sort the horizontal cuts' costs in descending order

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        // Iterate until both the horizontal and vertical cuts have been considered
        while (h < costHor.length && v < costVer.length) {
            // Case 1: Horizontal Cut Cost <= Vertical Cut Cost
            if (costVer[v] <= costHor[h]) {
                // Perform a horizontal cut
                cost += (costHor[h] * vp); // Add the cost of the horizontal cut multiplied by the current vertical pieces count
                hp++; // Increment the count of horizontal pieces
                h++; // Move to the next horizontal cut
            } else { // Case 2: Vertical Cut Cost < Horizontal Cut Cost
                // Perform a vertical cut
                cost += (costVer[v] * hp); // Add the cost of the vertical cut multiplied by the current horizontal pieces count
                vp++; // Increment the count of vertical pieces
                v++; // Move to the next vertical cut
            }
        }

        // Handle the remaining horizontal or vertical cuts, if any
        while (h < costHor.length) {
            cost += (costHor[h] * vp); // Add the cost of the remaining horizontal cuts
            hp++; // Increment the count of horizontal pieces
            h++; // Move to the next horizontal cut
        }
        while (v < costVer.length) {
            cost += (costVer[v] * hp); // Add the cost of the remaining vertical cuts
            vp++; // Increment the count of vertical pieces
            v++; // Move to the next vertical cut
        }

        System.out.println("Minimum cost of cuts = " + cost);
    }
}
