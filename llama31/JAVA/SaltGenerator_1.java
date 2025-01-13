import java.lang.String;
import java.security.SecureRandom;

public class SaltGenerator_1 {
    public static byte[] generateSalt(int size) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[size];
        random.nextBytes(salt);
        return salt;
    }

	public static void main(String[] args) {
	}
}