import java.util.*;

public class SpiralMatrix {

    public static void printSpiralMatrix(int matrix[][]) {
        int startRow, startColumn, endRow, endColumn;
        startRow = 0;
        startColumn = 0;
        endRow = matrix.length - 1;
        endColumn = matrix[0].length - 1;

        while (startRow <= endRow && startColumn <= endColumn) {
            // Top
            for (int j = startColumn; j <= endColumn; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // Right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endColumn] + " ");
            }
            // Bottom
            for (int j = endColumn - 1; j >= startColumn; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            // Left
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                if (startColumn == endColumn) {
                    break;
                }
                System.out.print(matrix[i][startColumn] + " ");
            }
            startRow++;
            startColumn++;
            endRow--;
            endColumn--;
        }
        System.out.println();
    }

    public static void DiagonalMatrixWithBruteForceMethod(int matrix[][]) {
        // Brute Force Methods Time Complexity = O(n^2)
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) // For Primary Diagonal
                {
                    sum += matrix[i][j];
                } else if (i + j == matrix.length - 1) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static int DiagonalMatrixWithLinearSearchMethod(int matrix[][]) {
        // Linear Search Methods Time Complexity = O(n)
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            // Primary Diagonal
            sum += matrix[i][i];
            // Secondary Diagonal
            if (i != matrix.length - 1 - i) // if i is not equal to j's value ( Length of Matrix - 1 - i). nahi toh already i ki value primary diagonal add ho gaya hai
            {
                sum += matrix[i][matrix.length - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String args[]) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        System.out.println(DiagonalMatrixWithLinearSearchMethod(matrix));

    }

}