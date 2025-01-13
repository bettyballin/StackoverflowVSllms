/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHasher {
    private static final int ITERATIONS = 10000;
    private static final int SALT_SIZE = 16;

    public static String hashPassword(String string) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray = new byte[16];
        secureRandom.nextBytes(byArray);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray, 10000, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] byArray2 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        return PasswordHasher.bytesToHex(byArray) + ":" + PasswordHasher.bytesToHex(byArray2);
    }

    private static String bytesToHex(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte by : byArray) {
            stringBuilder.append(String.format("%02x", by));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String string = "mysecretpassword";
        String string2 = PasswordHasher.hashPassword(string);
        System.out.println(string2);
    }
}
