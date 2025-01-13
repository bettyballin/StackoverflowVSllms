/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHasher_3 {
    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    public static byte[] hashPassword(String string) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] byArray = new byte[16];
        SecureRandom.getInstanceStrong().nextBytes(byArray);
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray, 10000, 256);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] byArray2 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        byte[] byArray3 = new byte[16 + byArray2.length];
        System.arraycopy(byArray, 0, byArray3, 0, 16);
        System.arraycopy(byArray2, 0, byArray3, 16, byArray2.length);
        return byArray3;
    }

    public static void main(String[] stringArray) {
    }
}
