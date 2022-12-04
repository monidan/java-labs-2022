import java.util.Arrays;

public class FourthTask implements Task {
    private double[][] matrix;

    FourthTask() {
        System.out.println("Введіть кількість стовпчиків матриці: n");
        final int columns = scanner.nextInt();

        System.out.println("Введіть кількість рядків матриці: m");
        final int rows = scanner.nextInt();

        boolean isKNumberInputCorrect = false;
        int k = 0;

        while (!isKNumberInputCorrect) {
            System.out.println("Введіть натуральне число: k");
            k = scanner.nextInt();

            if (k > 0) isKNumberInputCorrect = true;
        }

        this.matrix = this.initializeMatrix(columns, rows);
        this.randomizeMatrix();

        System.out.println("Matrix before multiplying on " + k + " -> " + Arrays.deepToString(this.matrix));

        final double[][] multipliedMatrix = this.multiplyMatrixElements(k);

        System.out.println("Matrixt after multiplying on " + k + " -> " + Arrays.deepToString(multipliedMatrix));
    }

    private double[][] initializeMatrix(int columns, int rows) {
           return new double[rows][columns];
    }

    private void randomizeMatrix() {
        for (int row = 0; row < this.matrix.length; row++) {
            for (int column = 0; column < this.matrix[row].length; column++) {
                this.matrix[row][column] = this.random.nextDouble();
            }
        }
    }

    private double[][] multiplyMatrixElements(int multipliedNumber) {
        double[][] multipliedMatrix = new double[this.matrix.length][this.matrix[0].length];
        int[] indexesOfMaxMatrixElement = this.findIndexesOfMaxMatrixElement();

        for (int row = 0; row < multipliedMatrix.length; row++) {
            for (int column = 0; column < multipliedMatrix[0].length; column++) {
                if ((column + 1) % 2 != 0 &&
                    (row + 1) % 2 == 0 &&
                    (row < indexesOfMaxMatrixElement[0] && column < indexesOfMaxMatrixElement[1])
                ) {
                    multipliedMatrix[row][column] = this.matrix[row][column] * multipliedNumber;
                } else {
                    multipliedMatrix[row][column] = this.matrix[row][column];
                }
            }
        }

        return multipliedMatrix;
    }

    private int[] findIndexesOfMaxMatrixElement() {
        double maxElement = 0;
        int[] indexes = new int[2];

        for (int row = 0; row < this.matrix.length; row++) {
            for (int column = 0; column < this.matrix[row].length; column++) {
                if (this.matrix[row][column] > maxElement) {
                    maxElement = this.matrix[row][column];
                    indexes = new int[]{row, column};
                }
            }
        }

        return indexes;
    }
}
