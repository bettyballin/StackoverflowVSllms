import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecretKeyHandler {
    // Example encrypted key (in reality, should be securely obtained)
    private static final byte[] ENCRYPTED_KEY = {83, -67, 12, 90, -122, 74};

    public static void main(String[] args) throws Exception {
        String encryptionKey = "SomeRandomSecret";
        SecretKeySpec secretKey = new SecretKeySpec(encryptionKey.getBytes(), "AES");
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        
        byte[] decryptedKey = cipher.doFinal(ENCRYPTED_KEY);
        String key = new String(decryptedKey);

        System.out.println("Decrypted Key: " + key);
    }
}