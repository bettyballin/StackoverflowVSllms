import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BracketDetector {
    public static void main(String[] args) {
        String regex = "\\[";
        String input = "Hello [ World";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Square bracket found!");
        }
    }
}