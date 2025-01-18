// Encryption and decryption example with AES (Java)
import javax.crypto.*;
import java.security.*;
import java.nio.charset.StandardCharsets;

public class Main_269 {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom random = new SecureRandom();

        // Generate AES secret key using secure random number generator
        keyGen.init(128, random);  // 128 is keysize length
        SecretKey sk = keyGen.generateKey();

        Cipher aesCipher = Cipher.getInstance("AES");
        String plainText = "This is the plaintext!";

        System.out.println("Plain Text : " + plainText);

        // AES encryption of data
        byte[] encryptedValue = aesEncrypt(aesCipher, sk, plainText);
        System.out.println("Encrypted :  " + convertToHex(encryptedValue));

        // AES decryption of data
        String decryptedMessage = aesDecrypt(aesCipher, sk, encryptedValue);
        System.out.println("Decrypted:   " + decryptedMessage);
    }

    public static byte[] aesEncrypt(Cipher cipher, SecretKey key, String plainText) throws Exception {
        // Initialize the cipher for encryption
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // Encrypt the plaintext
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return encryptedBytes;
    }

    public static String aesDecrypt(Cipher cipher, SecretKey key, byte[] encryptedBytes) throws Exception {
        // Initialize the cipher for decryption
        cipher.init(Cipher.DECRYPT_MODE, key);
        // Decrypt the ciphertext
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        return decryptedText;
    }

    public static String convertToHex(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }
}