/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class TokenGenerator_3 {
    private static final int TOKEN_LENGTH = 32;

    public static String generateToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
        return TokenGenerator_3.bytesToHex(byArray);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            String string = Integer.toHexString(0xFF & by);
            if (string.length() == 1) {
                stringBuilder.append('0');
            }
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
