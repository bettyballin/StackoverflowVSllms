/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main_90 {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String string = "mysecretpassword";
        byte[] byArray = "mysalt".getBytes();
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        PBEKeySpec pBEKeySpec = new PBEKeySpec(string.toCharArray(), byArray, 1000, 128);
        byte[] byArray2 = secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        System.out.println(byArray2.length);
    }
}
