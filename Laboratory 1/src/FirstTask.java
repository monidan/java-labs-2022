import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class FirstTask {
    private Scanner scanner;

    private ArrayList<Integer> flBoardersInt, slBoardersInt;

    FirstTask() {
        scanner = new Scanner(System.in);

        this.init();
    }

    private void init() {
        System.out.println("Напишіть границі першого відрізку: [a; b]");
        String firstLine = scanner.nextLine();

        System.out.println("Напишіть границі другого відрізку: [n; m]");
        String secondLine = scanner.nextLine();

        ArrayList<String> firstLineBoarders = new ArrayList<String>(Arrays.asList(firstLine.split(",")));
        ArrayList<String> secondLineBoarders = new ArrayList<String>(Arrays.asList(secondLine.split(",")));

        flBoardersInt = new ArrayList<Integer>();
        slBoardersInt = new ArrayList<Integer>();

        firstLineBoarders.forEach(item -> flBoardersInt.add(Integer.parseInt(item.trim())));
        secondLineBoarders.forEach(item -> slBoardersInt.add(Integer.parseInt(item.trim())));
    }
}
