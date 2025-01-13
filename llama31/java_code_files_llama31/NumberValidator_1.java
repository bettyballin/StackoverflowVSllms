/*
 * Decompiled with CFR 0.152.
 */
import java.util.regex.Pattern;

public class NumberValidator_1 {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[-+]?\\d{1,3}(?:,\\d{3})*(?:\\.\\d+)?(?:[eE][-+]?\\d+)?$");

    public boolean isANumber(String string) {
        return NUMBER_PATTERN.matcher(string).matches();
    }

    public static void main(String[] stringArray) {
    }
}
