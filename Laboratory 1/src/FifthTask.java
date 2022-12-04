public class FifthTask implements Task {
    private String sentence;

    FifthTask() {
        this.initiateInput();
        this.applyRules();
    }

    private void initiateInput() {
        System.out.println("Введіть речення:");
        sentence = scanner.nextLine();
    }

    private void applyRules() {
        String[] sentenceArr = this.sentence.split(" ");
        this.changeTargetLetterFirst(sentenceArr);

        System.out.println(String.join(" ", sentenceArr));
    }

    private String[] changeTargetLetterFirst(String[] sentenceArray) {
        if (sentenceArray[0].matches("та|Та|ТА")) {
            sentenceArray[0] = "І";
        }

        return sentenceArray;
    }
}
