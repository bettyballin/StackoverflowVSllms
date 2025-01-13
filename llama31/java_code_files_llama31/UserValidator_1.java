/*
 * Decompiled with CFR 0.152.
 */
public class UserValidator_1 {
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

    public boolean isValidEmail(String string) {
        return string.matches(EMAIL_PATTERN);
    }

    public static void main(String[] stringArray) {
    }
}
