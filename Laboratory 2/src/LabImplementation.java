import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LabImplementation {
    Scanner scanner = new Scanner(System.in);
    Random r = new Random();

    float[][] matrix;

    LabImplementation() {
        try {
            this.matrix = this.initiateInputOfMatrixData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private float[][] initiateInputOfMatrixData() throws Exception {
        int rows, columns;

        System.out.println("\nInput amount of rows and columns for the matrix (i.e. 2, 3):");
        String rowColumnInput = scanner.nextLine();

        String[] rowColumnArray = rowColumnInput.split(",");

        rows = Integer.parseInt(rowColumnArray[0].trim());
        columns = Integer.parseInt(rowColumnArray[1].trim());

//      Checking if columns and rows are positive
        if (rows <= 0 || columns <= 0) throw new Exception("Columns and rows cannot be negative or zero!");

        float[][] inputMatrix = new float[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                float value;

                System.out.println("\nInput float value for [" + (row + 1) + ", " + (column + 1) + "]:");
                value = scanner.nextFloat();

                inputMatrix[row][column] = value;
            }
        }

        // Check if matrix has negative numbers
        if (!this.isMatrixHasNegativeNumbers(inputMatrix)) throw new Exception("Matrix has no negative numbers!");

        // Random rule validation
        if (!this.validateRandomRule(inputMatrix)) throw new Exception("Random rule wasn't valid for this type of matrix!");

        this.findMinimum(inputMatrix);
        this.printMatrix(inputMatrix);

        return inputMatrix;
    }

    private void printMatrix(float[][] matrix) {
        System.out.println("[\n");
        for (int row = 0; row < matrix.length; row++) {
            System.out.print(" [ ");
            for (int column = 0; column < matrix[0].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.print("]\n");
        }
        System.out.println("\n]");
    }

    private void findMinimum(float[][] matrix) {
        float min = 0;
        int minItemRow = 0, minItemColumn = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] < min) {
                    min = matrix[row][column];
                    minItemRow = row;
                    minItemColumn = column;
                }
            }
        }

        System.out.println("\nMinimum element for the matrix is " + min);
        System.out.println("Row/column: " + (minItemRow + 1) + "/" + (minItemColumn + 1));
    }

    private boolean isMatrixHasNegativeNumbers(float[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                if (matrix[row][column] < 0) return true;
            }
        }

        return false;
    }

    private boolean validateRandomRule(float[][] matrix) {
        int randomRule = r.nextInt(2);

        if (randomRule == 0) {
//          First item of matrix is negative
            System.out.println("Validating random rule: <first item of matrix is negative>");
            return matrix[0][0] < 0;
        }

//      Matrix rows === columns
        System.out.println("Validating random rule: <rows are equal to columns>");
        return matrix.length == matrix[0].length;
    }
}