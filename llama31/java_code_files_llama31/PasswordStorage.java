/*
 * Decompiled with CFR 0.152.
 */
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordStorage {
    public static void main(String[] stringArray) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String string;
        PBEKeySpec pBEKeySpec;
        byte[] byArray;
        String string2 = "mysecretpassword";
        String string3 = "randomsaltvalue";
        PBEKeySpec pBEKeySpec2 = new PBEKeySpec(string2.toCharArray(), string3.getBytes(), 10000, 128);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] byArray2 = secretKeyFactory.generateSecret(pBEKeySpec2).getEncoded();
        if (Arrays.equals(byArray2, byArray = secretKeyFactory.generateSecret(pBEKeySpec = new PBEKeySpec((string = "mysecretpassword").toCharArray(), string3.getBytes(), 10000, 128)).getEncoded())) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is invalid");
        }
    }
}
