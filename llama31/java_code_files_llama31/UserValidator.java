/*
 * Decompiled with CFR 0.152.
 */
public class UserValidator {
    public static void main(String[] stringArray) {
        String string = "";
        String string2 = "";
        if (string.isEmpty() || string2.isEmpty()) {
            System.out.println("Invalid input: username and password cannot be empty.");
        } else {
            System.out.println("Valid input: username and password are not empty.");
        }
    }
}
