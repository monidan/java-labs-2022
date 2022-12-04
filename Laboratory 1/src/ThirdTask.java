import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ThirdTask {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private int[][] matrix;
    private int columnIndex;


    ThirdTask() {
        this.init();
    }

    private void init() {
        System.out.println("Введіть розмірність квадратної матриці: n");
        int matrixSize = scanner.nextInt();

        matrix = new int[matrixSize][matrixSize];

        System.out.println("Введіть число (номер стовпичка матриці): k");
        columnIndex = scanner.nextInt() - 1;

        this.randomizeMatrixValues();

        System.out.println("Randomized matrix -> " + Arrays.deepToString(this.matrix));

        System.out.println("Diagonal element -> " + this.findDiagonalElementInColumnByIndex(columnIndex));

        this.subtractFromColumnElement(this.findDiagonalElementInColumnByIndex(columnIndex));

        System.out.println("\nCalculated Matrix -> " + Arrays.deepToString(this.matrix));
    }

    private void subtractFromColumnElement(int subtractedNumber) {
        for (int row = 0; row < this.matrix.length; row++) {
            this.matrix[row][columnIndex] -= subtractedNumber;
        }
    }

    private int findDiagonalElementInColumnByIndex(int columnIndex) {
        return this.matrix[columnIndex][columnIndex];
    }

    private void randomizeMatrixValues() {
        for (int row = 0; row < this.matrix.length; row++) {
            for (int column = 0; column < this.matrix.length; column++) {
                this.matrix[row][column] = random.nextInt(100);
            }
        }
    }
}
