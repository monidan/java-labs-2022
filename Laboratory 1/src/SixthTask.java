public class SixthTask implements Task {
    SixthTask(String text) {
        String sentence = text;

        sentence = sentence.replaceAll("дім[\s|\\.]", "будинок ");
        sentence = sentence.replaceAll("Дім\s", "Будинок ");
        System.out.println(sentence);
    }
}
