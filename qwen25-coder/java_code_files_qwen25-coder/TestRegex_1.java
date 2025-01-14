import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TestRegex_1 {
    public static void main(String[] args) {
        String regex = "\\d+"; // Example regex
        String text = "There are 123 numbers in this sentence";

        // Java built-in regex engine
        Pattern patternJava = Pattern.compile(regex);
        Matcher matcherJava = patternJava.matcher(text);
        while (matcherJava.find()) {
            System.out.println("Java: " + matcherJava.group());
        }
    }
}