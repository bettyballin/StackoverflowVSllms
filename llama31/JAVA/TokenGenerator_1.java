import java.lang.String;
import java.security.SecureRandom;
import java.util.Base64;

public class TokenGenerator_1 {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateToken() {
        byte[] tokenBytes = new byte[32];
        secureRandom.nextBytes(tokenBytes);
        return Base64.getUrlEncoder().encodeToString(tokenBytes);
    }

	public static void main(String[] args) {
	}
}