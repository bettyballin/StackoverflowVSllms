/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class PasswordResetTokenGenerator {
    public static void main(String[] stringArray) {
        String string = "someToken";
        String string2 = UUID.randomUUID().toString();
        if (string.equals(string2)) {
            System.out.println("Password reset allowed");
        } else {
            System.out.println("Invalid token");
        }
    }
}
