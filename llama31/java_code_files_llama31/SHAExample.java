/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAExample {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException {
        String string = "Hello, World!";
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byArray = messageDigest.digest(string.getBytes());
        System.out.println(SHAExample.bytesToHex(byArray));
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
}
