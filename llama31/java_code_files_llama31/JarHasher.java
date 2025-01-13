/*
 * Decompiled with CFR 0.152.
 */
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class JarHasher {
    public static String computeHash(String string) throws IOException, NoSuchAlgorithmException {
        int n;
        InputStream inputStream = JarHasher.class.getResourceAsStream(string);
        if (inputStream == null) {
            throw new IOException("Jar file not found");
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] byArray = new byte[1024];
        while ((n = inputStream.read(byArray)) != -1) {
            messageDigest.update(byArray, 0, n);
        }
        inputStream.close();
        byte[] byArray2 = messageDigest.digest();
        return JarHasher.bytesToHex(byArray2);
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
