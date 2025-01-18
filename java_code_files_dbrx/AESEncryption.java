import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Base64;

public class AESEncryption {
    private final static String ALGO = "AES";
    private Key key;
    private SecretKeySpec secretKey;
    Cipher cipher;

    public AESEncryption() throws Exception {
        this.cipher = Cipher.getInstance(ALGO);
        initKeys(); // Create a new encryption / decryption key and initialize it.
    }

    private void initKeys() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        // Change this with your secure key (128 or 256 bit)
        secretKey = new SecretKeySpec("password".getBytes("UTF-8"), ALGO);
    }

    public String encrypt(String plainText) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey); // Initialize cipher to encryption mode
        byte[] encrypted = cipher.doFinal(plainText.getBytes());
        // Return the encoded data in BASE64 string format
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String encryptedText) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey); // Initialize cipher to decryption mode
        // Decode the BASE64 string and decrypt
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        return new String(cipher.doFinal(decodedBytes), "UTF8");
    }

    public static void main(String[] args) {
    }
}