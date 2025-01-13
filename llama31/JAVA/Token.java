import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class Token {
    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[16];
        random.nextBytes(bytes);
        return new String(Base64.getEncoder().encode(bytes));
    }

    public static void main(String[] args) {
        System.out.println(generateToken());
    }
}