import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnicodeValidator_1_1 {
    public static void main(String[] args) {
        String testString = "uʍop ǝpısdn";
        Pattern pattern = Pattern.compile("\\p{L}+"); // matches any Unicode letter
        Matcher matcher = pattern.matcher(testString);
        if (matcher.matches()) {
            System.out.println("UTF-8 compliant");
        }
    }
}