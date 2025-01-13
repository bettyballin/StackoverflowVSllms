import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Main_573 {

    public static void main(String[] args) throws Exception {
        // Generate a random key
        SecretKeySpec key = new SecretKeySpec(generateRandomKey(32), "AES");

        // Data to encrypt
        byte[] dataToEncrypt = "Hello, World!".getBytes();

        // Create a Cipher instance
        Cipher cipher = Cipher.getInstance("AES");

        // Encrypt data
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(dataToEncrypt);

        // Print the encrypted data
        System.out.println("Encrypted data: " + Base64.getEncoder().encodeToString(encryptedData));
    }

    // Function to generate a random key
    public static byte[] generateRandomKey(int size) {
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[size];
        secureRandom.nextBytes(key);
        return key;
    }
}