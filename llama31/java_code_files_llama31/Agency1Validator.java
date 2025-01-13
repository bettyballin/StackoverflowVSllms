/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Agency1Validator
extends EmailValidator {
    private static final String AGENCY1_PATTERN = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";

    @Override
    public boolean isValidEmail(String string) {
        Pattern pattern = Pattern.compile(AGENCY1_PATTERN);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    public static void main(String[] stringArray) {
    }
}
