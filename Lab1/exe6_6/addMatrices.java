import java.util.Scanner;

public class addMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Same size
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        
        int[][] matrix1 = new int[rows][columns];
        int[][] matrix2 = new int[rows][columns];

        // Input elements of the first matrix
        System.out.println("Enter the first matrix:");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                System.out.print("Enter matrix1 [" + (i + 1) + ", " + (j + 1) + "]: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Enter the second and find sum
        int[][] sumMatrix = new int[rows][columns];
        System.out.println("Enter the second matrix:");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                System.out.print("Enter matrix2 [" + (i + 1) + ", " + (j + 1) + "]: ");
                matrix2[i][j] = scanner.nextInt();
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Print
        System.out.println("Sum of the two matrices:");
        displayMatrix(sumMatrix);

        scanner.close();
    }

    // Display a matrix
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
