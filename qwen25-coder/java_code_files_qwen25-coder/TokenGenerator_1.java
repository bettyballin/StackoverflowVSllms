import java.lang.String;
import java.security.SecureRandom;

public class TokenGenerator_1 {
    private static final String CHAR_SET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final int TOKEN_LENGTH = 40;

    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(TOKEN_LENGTH);

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            token.append(CHAR_SET.charAt(random.nextInt(CHAR_SET.length())));
        }

        return token.toString();
    }

    public static void main(String[] args) {
    }
}