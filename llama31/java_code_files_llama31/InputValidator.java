/*
 * Decompiled with CFR 0.152.
 */
public class InputValidator {
    public String ValidateAndSanitize(String string) {
        return string.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void main(String[] stringArray) {
        InputValidator inputValidator = new InputValidator();
        String string = "Hello, World!";
        String string2 = inputValidator.ValidateAndSanitize(string);
        System.out.println(string2);
    }
}
