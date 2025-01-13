/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator_2 {
    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
        return Base64.getUrlEncoder().encodeToString(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
