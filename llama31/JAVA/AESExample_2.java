import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class AESExample_2 {
    public static void main(String[] args) throws Exception {
        // Key (16 bytes for AES-128, 32 bytes for AES-256)
        byte[] keyBytes = "your_secret_key_16_bytes_long".getBytes();
        Key key = new SecretKeySpec(keyBytes, "AES");

        // Create a Cipher instance
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize for encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Encrypt some data
        String plaintext = "Hello, World!";
        byte[] ciphertext = cipher.doFinal(plaintext.getBytes());

        // Print the encrypted data (Base64-encoded)
        System.out.println(Base64.getEncoder().encodeToString(ciphertext));
    }
}