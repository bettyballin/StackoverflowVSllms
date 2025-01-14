import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class AESEncryption_5 {
    public static void main(String[] args) throws Exception {
        // Generate a 256-bit AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // Initialize vector for encryption and decryption
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);

        IvParameterSpec spec = new IvParameterSpec(iv);

        // Create Cipher instance for encrypting data
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);
        byte[] encryptedData = cipher.doFinal("Sensitive Data".getBytes());

        // Create Cipher instance for decrypting data
        cipher.init(Cipher.DECRYPT_MODE, secretKey, spec);
        String decryptedText = new String(cipher.doFinal(encryptedData));

        System.out.println(decryptedText);  // Output: Sensitive Data
    }
}