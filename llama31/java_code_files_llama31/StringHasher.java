/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringHasher {
    public static long hashString(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
        return StringHasher.bytesToLong(byArray);
    }

    private static long bytesToLong(byte[] byArray) {
        long l = 0L;
        for (byte by : byArray) {
            l = l << 8 | (long)(by & 0xFF);
        }
        return l;
    }

    public static void main(String[] stringArray) {
    }
}
