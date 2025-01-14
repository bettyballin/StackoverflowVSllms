import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NumberValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile(
        "^(\\\\-?([0-9]+(\\\\.[0-9]+)?([eE][+-]?[0-9]+)?|[0-9]*\\\\.[0-9]+([eE][+-]?[0-9]+)?)$"
    );

    public static boolean isANumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Matcher matcher = NUMBER_PATTERN.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isANumber("123.55e-9")); // true
        System.out.println(isANumber("-333,556"));  // false
        System.out.println(isANumber("-21,22.22.2"));// false
        System.out.println(isANumber("33-2"));      // false
    }
}