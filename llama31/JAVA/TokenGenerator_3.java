import java.lang.Integer;
import java.lang.String;
import java.security.SecureRandom;

public class TokenGenerator_3 {
    private static final int TOKEN_LENGTH = 32; // 256 bits

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] tokenBytes = new byte[TOKEN_LENGTH];
        random.nextBytes(tokenBytes);
        return bytesToHex(tokenBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

	public static void main(String[] args) {
	}
}