// Example usage of JCA for encryption and decryption
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Main_278 {
    public static void main(String[] args) throws Exception {
        // Data to be encrypted
        byte[] sensitiveData = "Hello, World!".getBytes();

        // Encrypt data
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec("your_secret_key".getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedData = cipher.doFinal(sensitiveData);

        // Decrypt data
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Print the results
        System.out.println("Encrypted Data: " + new String(encryptedData));
        System.out.println("Decrypted Data: " + new String(decryptedData));
    }
}