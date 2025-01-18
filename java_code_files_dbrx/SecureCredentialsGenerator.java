import java.lang.String;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class SecureCredentialsGenerator {
    private static final int PASSWORD_LENGTH = 32; // 256-bit key size encoded in Base64 will be 43 characters long (with padding)

    public static String generateSecurePassword() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] passwordBytes = new byte[PASSWORD_LENGTH];
        secureRandom.nextBytes(passwordBytes);
        return Base64.getEncoder().encodeToString(passwordBytes);
    }

	public static void main(String[] args) {
	}
}