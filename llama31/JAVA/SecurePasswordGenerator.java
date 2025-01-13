import java.lang.String;
import java.security.SecureRandom;
import java.util.Base64;

public class SecurePasswordGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generatePassword(int length) {
        byte[] passwordBytes = new byte[length];
        secureRandom.nextBytes(passwordBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(passwordBytes);
    }

	public static void main(String[] args) {
	}
}