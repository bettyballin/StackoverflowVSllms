/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main_376 {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String string = "your_password_here";
        String string2 = "your_salt_here";
        int n = 65536;
        int n2 = 256;
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), string2.getBytes(), n, n2);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        SecretKey secretKey = secretKeyFactory.generateSecret(pBEKeySpec);
        byte[] byArray = secretKey.getEncoded();
    }
}
