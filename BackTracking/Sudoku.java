public class Sudoku {

    // This function recursively solves the Sudoku puzzle
    public static boolean sudokuSolver(int[][] sudoku, int row, int col) {
        // Base Case: if the current row is 9, then the puzzle is solved
        if (row == 9) {
            return true;
        }

        // Get the indices of the next cell
        int nextRow = row, nextCol = col + 1;
        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        // If the current cell is already filled, move on to the next cell
        if (sudoku[row][col] != 0) {
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        // Try out all the possible digits in the current cell
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoku, row, col, digit)) { // If the digit is safe to place
                sudoku[row][col] = digit; // Place the digit in the current cell

                // Recursively solve the puzzle for the next cell
                if (sudokuSolver(sudoku, nextRow, nextCol)) { // If the puzzle is solved
                    return true;
                }

                // If the puzzle cannot be solved with this digit, remove the digit
                sudoku[row][col] = 0;
            }
        }

        // If no digit works in the current cell, backtrack
        return false;
    }

    // This function checks if it is safe to place the given digit in the given cell
    public static boolean isSafe(int[][] sudoku, int row, int col, int digit) {
        // Check if the digit is already present in the same row or column
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == digit || sudoku[row][i] == digit) {
                return false;
            }
        }

        // Check if the digit is already present in the same 3x3 grid
        int gridRow = (row / 3) * 3;
        int gridCol = (col / 3) * 3;
        for (int i = gridRow; i < gridRow + 3; i++) {
            for (int j = gridCol; j < gridCol + 3; j++) {
                if (sudoku[i][j] == digit) {
                    return false;
                }
            }
        }

        // If the digit is safe to place in the current cell, return true
        return true;
    }

    // This function prints the Sudoku puzzle
    public static void printSudoku(int[][] sudoku) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        // Create the Sudoku puzzle
        int[][] sudoku = { 
            {3, 8, 5, 0, 0, 0, 0, 0, 0}, 
            {9, 2, 1, 0, 0, 0, 0, 0, 0}, 
            {6, 4, 7, 0, 0, 0, 0, 0, 0}, 
            {0, 0, 0, 1, 2, 3, 0, 0, 0}, 
            {0, 0, 0, 7, 8, 4, 0, 0, 0}, 
            {0, 0, 0, 6, 9, 5, 0, 0, 0}, 
            {0, 0, 0, 0, 0, 0, 8, 7, 3}, 
            {0, 0, 0, 0, 0, 0, 9, 6, 2}, 
            {0, 0, 0, 0, 0, 0, 1, 4, 5}, 
        };
        if(sudokuSolver(sudoku, 0, 0)){
            System.out.println("Solution Exist");
            printSudoku(sudoku);
        }
        else{
            System.out.println("Solution does not exist");
        }
    }
}
