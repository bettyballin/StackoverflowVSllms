import java.lang.String;
import java.security.SecureRandom;

public class SaltGenerator {
    public static byte[] generateSalt(int length) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[length];
        random.nextBytes(salt);
        return salt;
    }

	public static void main(String[] args) {
	}
}