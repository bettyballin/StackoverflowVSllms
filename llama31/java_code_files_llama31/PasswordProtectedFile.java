/*
 * Decompiled with CFR 0.152.
 */
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordProtectedFile {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final int ITERATIONS = 10000;

    public static byte[] encrypt(byte[] byArray, String string) throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] byArray2 = new byte[16];
        secureRandom.nextBytes(byArray2);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray2, 10000, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(1, secretKey);
        byte[] byArray3 = cipher.doFinal(byArray);
        byte[] byArray4 = new byte[byArray2.length + byArray3.length];
        System.arraycopy(byArray2, 0, byArray4, 0, byArray2.length);
        System.arraycopy(byArray3, 0, byArray4, byArray2.length, byArray3.length);
        return byArray4;
    }

    public static byte[] decrypt(byte[] byArray, String string) throws Exception {
        byte[] byArray2 = new byte[16];
        System.arraycopy(byArray, 0, byArray2, 0, byArray2.length);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray2, 10000, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(2, secretKey);
        byte[] byArray3 = cipher.doFinal(byArray, byArray2.length, byArray.length - byArray2.length);
        return byArray3;
    }

    public static void main(String[] stringArray) {
    }
}
