/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class PasswordGenerator {
    public static void main(String[] stringArray) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[32];
        secureRandom.nextBytes(byArray);
        String string = PasswordGenerator.bytesToHex(byArray);
        System.out.println(string);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
