import java.util.regex.*;

public class XSSDetector {
    String input = "..."; // this may include malicious XSS code like <script>...</script>, etc.
    Pattern pattern = Pattern.compile("<[^>]*>", Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(input);

    public XSSDetector() {
        if (matcher.find()) {
            throw new SecurityException("Cross-site Scripting vulnerability discovered.");
        }
    }

    public static void main(String[] args) {
        new XSSDetector();
    }
}