import java.lang.String;

public class SentenceFormatter {
    public static void main(String[] args) {
        String sentence = "Yesterday, I saw a %s eating a %s in the %s.";
        String animal = "dog";
        String food = "bone";
        String location = "park";

        String result = String.format(sentence, animal, food, location);
        System.out.println(result);
    }
}