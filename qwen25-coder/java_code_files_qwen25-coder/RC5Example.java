import javax.crypto.Cipher;
import java.security.KeyGenerator;
import java.security.SecureRandom;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;

public class RC5Example {
    public static void main(String[] args) throws Exception {
        // Add Bouncy Castle as a security provider
        Security.addProvider(new BouncyCastleProvider());

        // Initialize the key generator for RC5
        KeyGenerator keyGen = KeyGenerator.getInstance("RC5", "BC");
        SecureRandom secureRandom = new SecureRandom();
        keyGen.init(128, secureRandom); // You can choose a different key size like 64 or 256

        // Generate a key
        javax.crypto.SecretKey secretKey = keyGen.generateKey();

        // Initialize the cipher for encryption
        Cipher cipher = Cipher.getInstance("RC5/ECB/PKCS7Padding", "BC");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypt some data
        String plainText = "This is a test string";
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // Initialize the cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convert bytes back to String
        String decryptedText = new String(decryptedBytes);

        System.out.println("Original: " + plainText);
        System.out.println("Decrypted: " + decryptedText);
    }
}