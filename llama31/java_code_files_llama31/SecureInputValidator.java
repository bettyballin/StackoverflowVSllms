/*
 * Decompiled with CFR 0.152.
 */
public class SecureInputValidator {
    public static void validateInput(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
    }

    public static void main(String[] stringArray) {
    }
}
