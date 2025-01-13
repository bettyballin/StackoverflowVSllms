import java.lang.String;
import java.lang.Set;
import java.util.UUID;

public class PasswordResetService {
    public static void main(String[] args) {
        // Generate a password reset token
        String token = UUID.randomUUID().toString();

        // Set the token to expire after 30 minutes
        long expiresAt = System.currentTimeMillis() + (30 * 60 * 1000);

        // Send the password reset link via email
        String resetLink = "https://example.com/reset-password?token=" + token;
        // Send the email using a secure email service
        System.out.println("Password reset link: " + resetLink);
    }
}