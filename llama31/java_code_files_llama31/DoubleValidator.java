/*
 * Decompiled with CFR 0.152.
 */
public class DoubleValidator {
    public static void main(String[] stringArray) {
        String string = "123.45";
        try {
            Double.parseDouble(string);
            System.out.println("Valid double");
        }
        catch (NumberFormatException numberFormatException) {
            System.out.println("Invalid double");
        }
    }
}
