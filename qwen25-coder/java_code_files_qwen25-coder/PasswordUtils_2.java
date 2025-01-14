import java.lang.String;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class PasswordUtils_2 {

    private static final SecureRandom RANDOM = new SecureRandom();
    private static final int SALT_LENGTH = 16; // in bytes

    public static String getSaltedHash(String password) {
        byte[] salt = new byte[SALT_LENGTH];
        RANDOM.nextBytes(salt);

        byte[] hash = hashPassword(password, salt);
        return Base64.getEncoder().encodeToString(salt) + "," + Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyPassword(String passwordAttempt, String storedHash) {
        String[] parts = storedHash.split(",");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hash = Base64.getDecoder().decode(parts[1]);

        byte[] hashOfInput = hashPassword(passwordAttempt, salt);
        return MessageDigest.isEqual(hash, hashOfInput);
    }

    private static byte[] hashPassword(String password, byte[] salt) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-512");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        digest.reset();
        digest.update(salt);
        return digest.digest(password.getBytes(StandardCharsets.UTF_8));
    }


	public static void main(String[] args) {
	}
}