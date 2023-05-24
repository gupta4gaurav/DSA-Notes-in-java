public class RatInMaze {
    // Main function to solve the maze
    public static boolean solveMaze(int[][] maze) {
        int N = maze.length;
        int sol[][] = new int[N][N];
        // Call the recursive utility function to solve the maze
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        // Print the solution if it exists
        printSolution(sol);
        return true;
    }

    // Recursive utility function to solve the maze
    public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        // Base case: if we have reached the bottom-right corner of the maze
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y) == true) {
            // Check if the current cell is already part of the solution path
            if (sol[x][y] == 1) {
                return false;
            }
            // Mark the current cell as part of the solution path
            sol[x][y] = 1;
            // Recursively check if we can move down or right from the current cell
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }
            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }
            // If we cannot move down or right from the current cell, backtrack
            sol[x][y] = 0;
            return false;
        }
        // If maze[x][y] is not valid, return false
        return false;
    }

    // Function to check if a given cell is safe to move to
    public static boolean isSafe(int[][] maze, int x, int y) {
        // If (x, y) is outside the maze, return false
        // If (x, y) is not a valid cell (i.e., it contains a wall), return false
        // Otherwise, return true
        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

    // Function to print the solution path
    public static void printSolution(int[][] sol) {
        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }
        };
        solveMaze(maze);
    }
}
