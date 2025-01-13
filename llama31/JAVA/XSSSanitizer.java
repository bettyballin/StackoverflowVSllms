import java.lang.String;
import java.util.regex.Pattern;

public class XSSSanitizer {
    private static final String XSS_PATTERN = "\\b((?!(?:[^<>]*\\/>|[^>]*<\\/))(?:\\w+\\s*=\\s*(?:\".*?\"|'.*?'|[^>\\s]+)|\\w+\\s*=\\s*|\\w+\\s*=|\\s*\\w+\\s*=\\s*(?:\".*?\"|'.*?'|[^>\\s]+))+)";

    public static String sanitize(String input) {
        return input.replaceAll(XSS_PATTERN, "");
    }

    public static void main(String[] args) {
        String input = "<script>alert('XSS')</script>";
        String sanitized = sanitize(input);
        System.out.println(sanitized); // Output: ""
    }
}