import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.BadPaddingException;

public class SecureEncrypt {
    public static void main(String[] args) {
        String data = "Sensitive data";
        String key = "your_secret_key_16_chars_long"; // Store this securely!

        try {
            // Create an AES cipher instance
            Cipher cipher = Cipher.getInstance("AES");

            // Create a secret key spec
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "AES");

            // Encrypt the data
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(data.getBytes());

            // Decrypt the data
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypted = cipher.doFinal(encrypted);

            System.out.println("Decrypted: " + new String(decrypted));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm: " + e.getMessage());
        } catch (InvalidKeyException e) {
            System.out.println("Invalid key: " + e.getMessage());
        } catch (NoSuchPaddingException e) {
            System.out.println("No such padding: " + e.getMessage());
        } catch (IllegalBlockSizeException e) {
            System.out.println("Illegal block size: " + e.getMessage());
        } catch (BadPaddingException e) {
            System.out.println("Bad padding: " + e.getMessage());
        }
    }
}