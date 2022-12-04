import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SecondTask {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    private double[] numbers;
    private double targetNumber;

    SecondTask() {

        this.init();
    }

    private void init() {
        System.out.println("Введіть довжину масиву дійсних чисел: n");
        final int numbersArrayLength = scanner.nextInt();

        System.out.println("Задайте любе дійсне число");
        targetNumber = scanner.nextDouble();

        numbers = this.generateArrayOfRandomNumbers(numbersArrayLength);
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(this.findClosestNumberForArithmeticMean()));
    }

    private double[] generateArrayOfRandomNumbers(int length) {
        double[] randomizedArray = new double[length];
        for (int i = 0; i < length; i++) {
            randomizedArray[i] = random.nextDouble();
        }
        return randomizedArray;
    }

    private double[] findClosestNumberForArithmeticMean() {
        double[] foundNumbers = new double[2];
        double differenceWithTargetNumber = Double.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    break;
                }

                double currentDifferenceWithTargetNumber = Math.abs(targetNumber - this.findArithmeticMean(numbers[i], numbers[j]));

                if (currentDifferenceWithTargetNumber < differenceWithTargetNumber) {
                    differenceWithTargetNumber = currentDifferenceWithTargetNumber;
                    foundNumbers = new double[]{numbers[i], numbers[j]};
                }
            }
        }

        System.out.println(this.findArithmeticMean(foundNumbers[0], foundNumbers[1]));

        return foundNumbers;
    }

    private double findArithmeticMean(double firstNumber, double secondNumber) {
        return (firstNumber + secondNumber) / 2;
    }
}
