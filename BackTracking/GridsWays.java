public class GridsWays {
    // Recursive function to count the number of ways to reach the bottom-right cell
    // of the grid
    // starting from the given cell (i, j)
    public static int countGridWays(int i, int j, int n, int m) {
        // Base case: if the current cell is the bottom-right cell of the grid, return 1
        if (i == n && j == m) {
            return 1;
        }
        // Base case: if the current cell is out of bounds, return 0
        else if (i > n || j > m) {
            return 0;
        }
        // Recursive case: count the number of ways to reach the bottom-right cell
        // by moving one step down or one step right from the current cell
        int ways = countGridWays(i + 1, j, n, m) + countGridWays(i, j + 1, n, m);
        return ways;
    }

    // Main function to test the countGridWays function
    public static void main(String args[]) {
        int n = 3, m = 3;
        System.out.println(countGridWays(0, 0, n - 1, m - 1));
    }

}
