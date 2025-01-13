/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class EmailValidator_6 {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static boolean isValidEmail(String string) {
        return pattern.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
    }
}
