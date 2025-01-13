/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashExample {
    public static String hashData(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes());
            return HashExample.bytesToHex(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
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
