import java.lang.String;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSFilter {
    private static final String XSS_PATTERN = "(<[^>]+>)|(<script\\b[^<]*(?:(?!<\\/script>).)*<\\/script>)";

    public static boolean containsXSS(String value) {
        Pattern pattern = Pattern.compile(XSS_PATTERN, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static void main(String[] args) {
        String testString1 = "<script>alert('XSS')</script>";
        String testString2 = "Hello, this is a safe message.";
        
        System.out.println(containsXSS(testString1)); // true
        System.out.println(containsXSS(testString2)); // false
    }
}