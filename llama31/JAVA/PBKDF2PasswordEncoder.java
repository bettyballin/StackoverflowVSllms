import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PBKDF2PasswordEncoder {
    public static byte[] deriveKey(String password, String salt, int iterations) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, 256);
        return factory.generateSecret(spec).getEncoded();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "password";
        String salt = "salt";
        int iterations = 1000;
        byte[] derivedKey = deriveKey(password, salt, iterations);
    }
}