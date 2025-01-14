import java.lang.String;
import java.security.SecureRandom;

public class TokenGenerator_2 {
    private static final int TOKEN_LENGTH = 32; // 256 bits for a secure token

    public String generateSecureToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[TOKEN_LENGTH];
        random.nextBytes(bytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString(); // hex representation of the token
    }

	public static void main(String[] args) {
	}
}