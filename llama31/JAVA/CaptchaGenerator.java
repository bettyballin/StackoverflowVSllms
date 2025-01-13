import java.lang.String;
import java.security.SecureRandom;
import java.util.Base64;

public class CaptchaGenerator {
    private static final SecureRandom random = new SecureRandom();

    public static String generateCaptchaString(int length) {
        byte[] bytes = new byte[length];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().encodeToString(bytes);
    }

	public static void main(String[] args) {
	}
}