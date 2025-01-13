import java.lang.String;
import java.security.SecureRandom;

public class TokenGenerator_2 {
    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[32]; // 32 bytes = 256 bits
        random.nextBytes(bytes);
        return java.util.Base64.getUrlEncoder().encodeToString(bytes);
    }

	public static void main(String[] args) {
	}
}