/*
 * Decompiled with CFR 0.152.
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main_419 {
    public static void main(String[] stringArray) {
        byte[] byArray = "Hello, World!".getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] byArray2 = messageDigest.digest(byArray);
            System.out.println("Data: " + new String(byArray));
            System.out.println("Checksum: " + Main_419.bytesToHex(byArray2));
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.err.println("Error: " + noSuchAlgorithmException.getMessage());
        }
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
