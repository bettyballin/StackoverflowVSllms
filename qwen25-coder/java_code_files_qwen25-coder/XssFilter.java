import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XssFilter {
    public static void main(String[] args) {
        String input = "This is a test with <select> tag and some <script>. Also, here is another > example.";
        String regex = "(?<!<select>)<|>(?!/select>|select>)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Replace all occurrences of the unwanted angle brackets outside <select>
        String sanitizedInput = matcher.replaceAll("");
        
        System.out.println("Original: " + input);
        System.out.println("Sanitized: " + sanitizedInput);
    }
}