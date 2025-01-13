import java.lang.String;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

public class PasswordHasher_3 {
    private static final int SALT_LENGTH = 16;
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;

    public static byte[] hashPassword(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        // Generate a random salt
        byte[] salt = new byte[SALT_LENGTH];
        java.security.SecureRandom.getInstanceStrong().nextBytes(salt);

        // Create a PBEKeySpec
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);

        // Hash the password
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = f.generateSecret(spec).getEncoded();

        // Return the salt and hash
        byte[] result = new byte[SALT_LENGTH + hash.length];
        System.arraycopy(salt, 0, result, 0, SALT_LENGTH);
        System.arraycopy(hash, 0, result, SALT_LENGTH, hash.length);
        return result;
    }

	public static void main(String[] args) {
	}
}