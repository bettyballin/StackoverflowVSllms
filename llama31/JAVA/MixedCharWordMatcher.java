import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MixedCharWordMatcher {
    public static void main(String[] args) {
        String input = "fr1&nd$ friends";
        Pattern pattern = Pattern.compile("\\b(?=\\w*[a-zA-Z])(?=\\w*[^\\w\\s])\\w+\\b");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.println(matcher.group()); // prints "fr1&nd$"
        }
    }
}