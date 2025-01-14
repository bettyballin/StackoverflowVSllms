import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESEncryptionExample_1 {
    public static void main(String[] args) throws Exception {
        // Generate AES key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // for example
        SecretKey secretKey = keyGen.generateKey();

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        // Encrypt data
        String originalString = "Hello, World!";
        byte[] stringBytes = originalString.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(stringBytes);

        // Decrypt data
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedString = new String(decryptedBytes);

        System.out.println("Original: " + originalString);
        System.out.println("Decrypted: " + decryptedString);
    }
}