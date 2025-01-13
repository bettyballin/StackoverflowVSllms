/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator_1 {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static boolean isValidEmail(String string) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] stringArray) {
        System.out.println(EmailValidator_1.isValidEmail("info@example.com"));
        System.out.println(EmailValidator_1.isValidEmail("john@host.com"));
        System.out.println(EmailValidator_1.isValidEmail("George <g.top@host.com>"));
        System.out.println(EmailValidator_1.isValidEmail("jim.p@web.com."));
        System.out.println(EmailValidator_1.isValidEmail("sue-allen@web.com"));
    }
}
