/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main_123 {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] byArray = new byte[16];
        new SecureRandom().nextBytes(byArray);
        String string = "userPassword";
        int n = 10000;
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray, n, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] byArray2 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        System.out.println("Salt: " + Main_123.bytesToHex(byArray));
        System.out.println("Hash: " + Main_123.bytesToHex(byArray2));
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }
}
