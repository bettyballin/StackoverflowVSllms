/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class SessionIdGenerator {
    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LENGTH = 32;

    public static String generateSessionId() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder(32);
        for (int i = 0; i < 32; ++i) {
            stringBuilder.append(CHARACTERS.charAt(secureRandom.nextInt(CHARACTERS.length())));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
