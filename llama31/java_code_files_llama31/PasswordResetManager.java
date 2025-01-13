/*
 * Decompiled with CFR 0.152.
 */
import java.util.UUID;

public class PasswordResetManager {
    public static void main(String[] stringArray) {
        String string = UUID.randomUUID().toString();
        User user = new User();
        user.setResetToken(string);
        user.setResetTokenExpiration(System.currentTimeMillis() + 1800000L);
        String string2 = "https://example.com/reset-password?token=" + string;
        String string3 = string;
        if (string3.equals(user.getResetToken()) && System.currentTimeMillis() < user.getResetTokenExpiration()) {
            System.out.println("Valid token, allowing password reset.");
        } else {
            System.out.println("Invalid or expired token, denying access.");
        }
    }
}
