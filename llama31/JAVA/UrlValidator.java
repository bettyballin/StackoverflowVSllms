import java.util.regex.Pattern;

public class UrlValidator {
    String urlPattern = "^https?://[^\\s]+$";

    public static void main(String[] args) {
        UrlValidator validator = new UrlValidator();
        System.out.println(Pattern.matches(validator.urlPattern, "http://example.com"));  // prints: true
        System.out.println(Pattern.matches(validator.urlPattern, "https://example.com")); // prints: true
        System.out.println(Pattern.matches(validator.urlPattern, "ftp://example.com"));   // prints: false
    }
}