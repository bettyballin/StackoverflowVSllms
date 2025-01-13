/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class DoubleValidator_1 {
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[-+]?\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?$");

    public static boolean isValidDouble(String string) {
        return DOUBLE_PATTERN.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
        System.out.println(DoubleValidator_1.isValidDouble("123.45"));
        System.out.println(DoubleValidator_1.isValidDouble("hello"));
    }
}
