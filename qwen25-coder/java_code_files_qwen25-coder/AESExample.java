import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class AESExample {
    public static void main(String[] args) throws Exception {
        // Generate a SecretKey for AES
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();
        keyGen.init(128, random); // Key size: 128 bits
        SecretKey secretKey = keyGen.generateKey();

        // Data to encrypt
        String data = "Your sensitive information here";
        byte[] dataBytes = data.getBytes("UTF-8");

        // Initialize Cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Encrypting the data
        byte[] encryptedData = cipher.doFinal(dataBytes);
        System.out.println("Encrypted data: " + new String(encryptedData));

        // Initialize Cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decrypting the data
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println("Decrypted data: " + new String(decryptedData));
    }
}