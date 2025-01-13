/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class UniqueFileNameGenerator_1 {
    public static String generateUniqueFileName() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        String string = UniqueFileNameGenerator_1.bytesToHex(byArray);
        return string;
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
