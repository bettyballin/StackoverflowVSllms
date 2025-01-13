/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class EmailValidator_7 {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    public static boolean isValidEmail(String string) {
        return EMAIL_PATTERN.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
    }
}
