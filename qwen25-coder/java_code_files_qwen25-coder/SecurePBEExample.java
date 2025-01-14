import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class SecurePBEExample {

    private static final int PBKDF2_ITERATIONS = 65536; // Recommended as of 2023
    private static final int KEY_SIZE = 256; // AES-256

    public static void main(String[] args) throws Exception {
        String password = "strongPassword";
        byte[] salt = new byte[16]; // Generate a random 16-byte salt
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(salt);

        String dataToEncrypt = "This is the data to encrypt.";
        
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray(), salt, PBKDF2_ITERATIONS, KEY_SIZE);
        byte[] keyBytes = factory.generateSecret(pbeKeySpec).getEncoded();

        // Generate a random IV
        byte[] ivBytes = new byte[16];
        sr.nextBytes(ivBytes);

        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

        byte[] encryptedData = cipher.doFinal(dataToEncrypt.getBytes());

        // Store the salt and IV along with the encrypted data - needed for decryption

        System.out.println("Encrypted Data: " + java.util.Base64.getEncoder().encodeToString(encryptedData));
    }
}