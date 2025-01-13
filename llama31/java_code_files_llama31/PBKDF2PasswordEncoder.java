/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PBKDF2PasswordEncoder {
    public static byte[] deriveKey(String string, String string2, int n) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), string2.getBytes(), n, 256);
        return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
    }

    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String string = "password";
        String string2 = "salt";
        int n = 1000;
        byte[] byArray = PBKDF2PasswordEncoder.deriveKey(string, string2, n);
    }
}
