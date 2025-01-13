import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sanitizer_7 {
    public static String sanitize(String input) {
        // trim() is equivalent to PHP's trim()
        input = input.trim();
        
        // Using String.replace() to escape special characters like HTML entities
        input = input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace("'", "&#x27;");
        
        // Using regular expression to remove HTML tags
        Pattern pattern = Pattern.compile("<.*?>");
        Matcher matcher = pattern.matcher(input);
        input = matcher.replaceAll("");
        
        return input;
    }

    public static void main(String[] args) {
        System.out.println(sanitize("Hello <b>World</b>!"));
    }
}