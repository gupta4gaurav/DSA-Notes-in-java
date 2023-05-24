public class Assignment {

    public static void printMatrix(int[][] matrix) {
        System.out.println("The matrix is: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "  "); // prints the value of the element
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int row = 3, column = 3;
        int[][] matrix = { { 1, 4, 9 }, { 11, 4, 3 }, { 2, 2, 3 } };

        printMatrix(matrix);

        int[][] transpose = new int[column][row]; // Trap
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transpose[j][i] = matrix[i][j]; // Trap
            }
        }
        // print the transposed matrix.
        printMatrix(transpose);

    }
}