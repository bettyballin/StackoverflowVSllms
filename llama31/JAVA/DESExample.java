import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DESExample {
    public static void main(String[] args) throws Exception {
        String plaintext = "Hello, World!";
        String key = "your_secret_key";

        // Create a DES cipher instance
        Cipher cipher = Cipher.getInstance("DES");

        // Create a secret key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "DES");

        // Encrypt the plaintext
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

        // Decrypt the ciphertext
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(ciphertext);

        System.out.println("Decrypted: " + new String(decrypted));
    }
}