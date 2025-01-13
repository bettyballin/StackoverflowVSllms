/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;

public class UniqueIdGenerator_1 {
    public static String generateId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        return UniqueIdGenerator_1.bytesToHex(byArray);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
