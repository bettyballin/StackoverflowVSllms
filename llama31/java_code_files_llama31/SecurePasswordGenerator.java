/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import java.util.Base64;

public class SecurePasswordGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generatePassword(int n) {
        byte[] byArray = new byte[n];
        secureRandom.nextBytes(byArray);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(byArray);
    }

    public static void main(String[] stringArray) {
    }
}
