import java.lang.String;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator_1 {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidEmail("info@example.com"));  // true
        System.out.println(isValidEmail("john@host.com"));  // true
        System.out.println(isValidEmail("George <g.top@host.com>"));  // false
        System.out.println(isValidEmail("jim.p@web.com."));  // false
        System.out.println(isValidEmail("sue-allen@web.com"));  // true
    }
}