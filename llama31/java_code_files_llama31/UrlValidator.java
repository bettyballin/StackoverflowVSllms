/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class UrlValidator {
    String urlPattern = "^https?://[^\\s]+$";

    public static void main(String[] stringArray) {
        UrlValidator urlValidator = new UrlValidator();
        System.out.println(Pattern.matches(urlValidator.urlPattern, "http://example.com"));
        System.out.println(Pattern.matches(urlValidator.urlPattern, "https://example.com"));
        System.out.println(Pattern.matches(urlValidator.urlPattern, "ftp://example.com"));
    }
}
