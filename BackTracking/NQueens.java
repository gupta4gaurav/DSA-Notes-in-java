public class NQueens {

    // Check if it is safe to place a queen at the given row and column on the board
    public static boolean isSafe(char[][] board, int row, int column) {
        // Check vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        // Check diagonal left up
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check diagonal right up
        for (int i = row - 1, j = column + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    // Place queens recursively on the board starting from the given row
    public static boolean nQueens(char[][] board, int row) {
        // Base case: all rows have been filled with queens
        if (row == board.length) {
            return true;
        }
        // Recursive case: try placing queens in each column of the current row
        for (int column = 0; column < board.length; column++) {
            if (isSafe(board, row, column)) {
                // Place queen and move to next row
                board[row][column] = 'Q';
                if((nQueens(board, row + 1))){
                    return true;
                }

                // Backtrack: remove queen and try next column
                board[row][column] = 'x';
            }
        }
        return false;
    }

    // Print the current state of the board
    public static void printBoard(char[][] board) {
        System.out.println("------------ chess board");
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board.length; column++) {
                System.out.print(board[row][column] + " ");
            }
            System.out.println();
        }
    }


    // Main function: initialize board and start recursive queen placement
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        // Initialize board with empty cells
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                board[row][column] = 'x';
            }
        }
        // Start recursive queen placement
        if(nQueens(board, 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }
        else{
            System.out.println("Solution is not possible.");
        }
        
        System.out.println();

    }
}
