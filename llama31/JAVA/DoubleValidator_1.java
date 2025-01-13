import java.lang.String;
import java.util.regex.Pattern;

public class DoubleValidator_1 {
    private static final Pattern DOUBLE_PATTERN = Pattern.compile(
            "^[-+]?\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?$");

    public static boolean isValidDouble(String input) {
        return DOUBLE_PATTERN.matcher(input).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidDouble("123.45")); // true
        System.out.println(isValidDouble("hello")); // false
    }
}