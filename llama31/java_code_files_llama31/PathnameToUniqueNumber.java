/*
 * Decompiled with CFR 0.152.
 */
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PathnameToUniqueNumber {
    public static long pathnameToUniqueNumber(String string) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
        long l = PathnameToUniqueNumber.bytesToLong(byArray);
        return l;
    }

    private static long bytesToLong(byte[] byArray) {
        long l = 0L;
        for (byte by : byArray) {
            l = l << 8 | (long)(by & 0xFF);
        }
        return l;
    }

    public static void main(String[] stringArray) throws NoSuchAlgorithmException {
        String string = "C:\\temp\\a.out";
        long l = PathnameToUniqueNumber.pathnameToUniqueNumber(string);
        System.out.println("Unique Number: " + l);
    }
}
