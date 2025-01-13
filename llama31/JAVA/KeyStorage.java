import java.lang.String;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class KeyStorage {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String KEY_PASSWORD = "mysecretpassword";

    public static void main(String[] args) throws Exception {
        // Generate a random key
        Key key = new SecretKeySpec(generateRandomBytes(16), ALGORITHM);

        // Encrypt the key
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY_PASSWORD.getBytes(), ALGORITHM));
        byte[] encryptedKey = cipher.doFinal(key.getEncoded());

        // Store the encrypted key
        String encodedKey = Base64.getEncoder().encodeToString(encryptedKey);
        System.out.println("Encrypted key: " + encodedKey);
    }

    private static byte[] generateRandomBytes(int length) {
        byte[] bytes = new byte[length];
        new java.security.SecureRandom().nextBytes(bytes);
        return bytes;
    }
}