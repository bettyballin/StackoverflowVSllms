import java.util.UUID;

public class PasswordResetTokenGenerator {
    public static void main(String[] args) {
        // Generate a random token for password reset
        String token = UUID.randomUUID().toString();

        // Send the token to the user's registered phone number or email address
        // ...

        // Validate the token when the user attempts to reset their password
        String requestToken = "someToken"; // replace with actual request token
        if (requestToken.equals(token)) {
            // Allow password reset
            System.out.println("Password reset allowed");
        } else {
            System.out.println("Invalid token");
        }
    }
}