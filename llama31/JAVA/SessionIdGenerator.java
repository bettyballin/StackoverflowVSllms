import java.lang.String;
import java.security.SecureRandom;

public class SessionIdGenerator {
    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int LENGTH = 32;

    public static String generateSessionId() {
        SecureRandom random = new SecureRandom();
        StringBuilder sessionId = new StringBuilder(LENGTH);
        for (int i = 0; i < LENGTH; i++) {
            sessionId.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sessionId.toString();
    }

	public static void main(String[] args) {
	}
}