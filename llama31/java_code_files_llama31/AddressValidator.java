/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class AddressValidator {
    private static final Pattern STREET_NUMBER_PATTERN = Pattern.compile("^[0-9]+([A-Za-z]+)?$");
    private static final Pattern ZIP_CODE_PATTERN = Pattern.compile("^[0-9]{5}(-[0-9]{4})?$");

    public boolean isValidAddress(String string, String string2, String string3, String string4, String string5) {
        string = string.trim().toUpperCase();
        string2 = string2.trim().toUpperCase();
        string3 = string3.trim().toUpperCase();
        string4 = string4.trim().toUpperCase();
        string5 = string5.trim().toUpperCase();
        if (string.isEmpty() || string2.isEmpty() || string3.isEmpty() || string4.isEmpty() || string5.isEmpty()) {
            return false;
        }
        if (!ZIP_CODE_PATTERN.matcher(string5).matches()) {
            return false;
        }
        return STREET_NUMBER_PATTERN.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
    }
}
