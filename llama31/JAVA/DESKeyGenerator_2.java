import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class DESKeyGenerator_2_2 {
    // Secure way to create a DES key using a key derivation function
    String secretKey = "my_secret_key";
    byte[] salt = new byte[16];
    SecureRandom random = new SecureRandom();
    KeySpec spec;
    SecretKey key;

    public DESKeyGenerator_2() throws NoSuchAlgorithmException, InvalidKeySpecException {
        random.nextBytes(salt);
        spec = new PBEKeySpec(secretKey.toCharArray(), salt, 10000, 56);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        key = f.generateSecret(spec);
    }

    public static void main(String[] args) {
        try {
            new DESKeyGenerator_2();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            System.err.println(e.getMessage());
        }
    }
}