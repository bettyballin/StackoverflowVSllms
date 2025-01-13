/*
 * Decompiled with CFR 0.152.
 */
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {
    public static String encrypt(String string, String string2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, secretKeySpec);
            byte[] byArray = cipher.doFinal(string.getBytes());
            return Base64.getEncoder().encodeToString(byArray);
        }
        catch (Exception exception) {
            System.out.println("Error while encrypting: " + exception.toString());
            return null;
        }
    }

    public static String decrypt(String string, String string2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            byte[] byArray = cipher.doFinal(Base64.getDecoder().decode(string));
            return new String(byArray);
        }
        catch (Exception exception) {
            System.out.println("Error while decrypting: " + exception.toString());
            return null;
        }
    }

    public static void main(String[] stringArray) {
    }
}
