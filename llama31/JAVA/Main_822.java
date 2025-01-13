import java.security.SecureRandom;

public class Main_822 {
    public static void main(String[] args) {
        // Generate a secure session ID
        SecureRandom random = new SecureRandom();
        String sessionId = String.valueOf(random.nextLong());
        System.out.println(sessionId);
    }
}