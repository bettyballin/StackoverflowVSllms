/*
 * Decompiled with CFR 0.152.
 */
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main_583 {
    public static void main(String[] stringArray) {
        String string = Main_583.generateToken();
        String string2 = Instant.now().plus(15L, ChronoUnit.MINUTES).toString();
        User user = new User();
        user.setEmail("example@example.com");
        user.setValidationToken(string);
        user.setValidationTokenExpiration(string2);
        Main_583.sendEmail(user.getEmail(), "Validate your account", "https://example.com/validate?token=" + string);
    }

    public static String generateToken() {
        return "random-token";
    }

    public static void sendEmail(String string, String string2, String string3) {
        System.out.println("Email sent to " + string + " with subject " + string2 + " and body " + string3);
    }
}
