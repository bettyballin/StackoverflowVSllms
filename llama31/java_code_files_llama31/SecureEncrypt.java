/*
 * Decompiled with CFR 0.152.
 */
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class SecureEncrypt {
    public static void main(String[] stringArray) {
        String string = "Sensitive data";
        String string2 = "your_secret_key_16_chars_long";
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKeySpec = new SecretKeySpec(string2.getBytes(), "AES");
            cipher.init(1, secretKeySpec);
            byte[] byArray = cipher.doFinal(string.getBytes());
            cipher.init(2, secretKeySpec);
            byte[] byArray2 = cipher.doFinal(byArray);
            System.out.println("Decrypted: " + new String(byArray2));
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            System.out.println("No such algorithm: " + noSuchAlgorithmException.getMessage());
        }
        catch (InvalidKeyException invalidKeyException) {
            System.out.println("Invalid key: " + invalidKeyException.getMessage());
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            System.out.println("No such padding: " + noSuchPaddingException.getMessage());
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            System.out.println("Illegal block size: " + illegalBlockSizeException.getMessage());
        }
        catch (BadPaddingException badPaddingException) {
            System.out.println("Bad padding: " + badPaddingException.getMessage());
        }
    }
}
