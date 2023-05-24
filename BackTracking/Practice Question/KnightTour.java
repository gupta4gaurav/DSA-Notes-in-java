class KnightTour {

    // Define the size of the chessboard
    static int N = 8;

    // Check if the move (x,y) is safe for the knight to move
    static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    // Print the solution matrix containing the moves of the knight
    static void printSolution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(sol[x][y] + " ");
            }
            System.out.println();
        }
    }

    // Main method to solve the knight's tour problem
    static boolean solveKT() {
        int[][] sol = new int[8][8];

        // Initialize solution matrix with -1 values
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        // Define the possible moves for the knight
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        // Mark the starting position (0,0) as visited
        sol[0][0] = 0;

        // Solve the problem using recursive utility function
        if (!solveKTUtil(0, 0, 1, sol, xMove, yMove)) {
            System.out.println("Solution does not exist");
            return false;
        } else {
            // Print the solution matrix
            printSolution(sol);
        }
        return true;
    }

    // Recursive utility function to solve the knight's tour problem
    static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int xMove[], int yMove[]) {
        int k, next_x, next_y;

        // Base case: if all squares are visited, return true
        if (movei == N * N) {
            return true;
        }

        // Try all next moves from the current coordinate (x,y)
        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                // Mark the square as visited and move to the next square
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove)) {
                    // If the next move leads to a solution, return true
                    return true;
                } else {
                    // Backtrack: If the next move does not lead to a solution, undo the move
                    sol[next_x][next_y] = -1;
                }
            }
        }

        // If all moves from the current coordinate fail, return false
        return false;
    }

    public static void main(String args[]) {
        // Solve the knight's tour problem and print the solution
        solveKT();
    }
}
