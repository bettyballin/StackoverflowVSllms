import java.lang.String;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AESEncryption {
    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = new byte[16]; // Ensure this is securely managed in production

    public static void main(String[] args) throws Exception {
        SecretKey secretKey = new SecretKeySpec(KEY, ALGORITHM);
        
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        String originalString = "Sensitive Data";
        
        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(originalString.getBytes());
        String encodedEncryptedString = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted: " + encodedEncryptedString);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedEncryptedBytes = Base64.getDecoder().decode(encodedEncryptedString);
        byte[] decryptedBytes = cipher.doFinal(decodedEncryptedBytes);
        String decryptedString = new String(decryptedBytes);
        System.out.println("Decrypted: " + decryptedString);
    }
}