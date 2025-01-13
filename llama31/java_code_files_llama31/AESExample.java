/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESExample {
    public static void main(String[] stringArray) throws Exception {
        String string = "Hello, World!";
        SecretKey secretKey = AESExample.generateKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(1, secretKey);
        byte[] byArray = cipher.doFinal(string.getBytes());
        System.out.println("Encrypted: " + AESExample.bytesToHex(byArray));
        cipher.init(2, secretKey);
        byte[] byArray2 = cipher.doFinal(byArray);
        System.out.println("Decrypted: " + new String(byArray2));
    }

    private static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
