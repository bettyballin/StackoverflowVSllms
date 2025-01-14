import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths; // Import necessary classes

public class PasswordEncryptorDecryptor {

    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;

    public static void main(String[] args) throws Exception {
        String plainTextPassword = "mySecretPassword";

        // Generate or store a secret key securely
        SecretKey secretKey = generateKey(KEY_SIZE);
        byte[] encodedKey = secretKey.getEncoded();
        SecretKeySpec originalKey = new SecretKeySpec(encodedKey, ALGORITHM);

        // Encrypt the password
        byte[] encryptedBytes = encrypt(plainTextPassword.getBytes(), originalKey);
        String encryptedPassword = encodeBase64(encryptedBytes); // Save this in your config file

        // Decrypt the password (read from config file)
        byte[] decodedEncryptedPassword = decodeBase64(encryptedPassword); // Read encrypted password
        byte[] decryptedBytes = decrypt(decodedEncryptedPassword, originalKey);
        String decryptedPassword = new String(decryptedBytes);

        System.out.println("Original Password: " + plainTextPassword);
        System.out.println("Decrypted Password: " + decryptedPassword);
    }

    private static SecretKey generateKey(int n) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }

    private static byte[] encrypt(byte[] plainText, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainText);
    }

    private static byte[] decrypt(byte[] encryptedBytes, SecretKeySpec secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(encryptedBytes);
    }

    // Base64 encoding and decoding utility methods
    public static String encodeBase64(byte[] bytes) {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }

    public static byte[] decodeBase64(String base64) {
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        return decoder.decode(base64);
    }
}