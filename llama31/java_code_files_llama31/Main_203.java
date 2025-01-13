/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main_203 {
    public static String hashString(String string, String string2) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = (string + string2).getBytes();
            for (int i = 0; i < 10000; ++i) {
                messageDigest.update(byArray);
                byArray = messageDigest.digest();
            }
            return Main_203.bytesToHex(byArray);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
        System.out.println(Main_203.hashString("Hello", "World"));
    }
}
