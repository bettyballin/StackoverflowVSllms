/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Base64;

public class CaptchaGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generateCaptchaString(int n) {
        byte[] byArray = new byte[n];
        random.nextBytes(byArray);
        return Base64.getUrlEncoder().encodeToString(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
