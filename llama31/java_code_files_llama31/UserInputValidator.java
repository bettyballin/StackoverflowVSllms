/*
 * Decompiled with CFR 0.152.
 */
public class UserInputValidator {
    public static void main(String[] stringArray) {
        String string = null;
        if (string == null || string.isEmpty()) {
            System.out.println("Invalid input");
        } else {
            String string2 = string.replaceAll("[^a-zA-Z0-9]", "");
            System.out.println(string2);
        }
    }
}
