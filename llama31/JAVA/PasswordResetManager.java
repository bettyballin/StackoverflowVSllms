import java.util.UUID;

public class PasswordResetManager {
    public static void main(String[] args) {
        // Generate a random token
        String token = UUID.randomUUID().toString();

        // Assuming a User class with setResetToken, setResetTokenExpiration, getResetToken, and getResetTokenExpiration methods
        User user = new User();
        user.setResetToken(token);
        user.setResetTokenExpiration(System.currentTimeMillis() + 30 * 60 * 1000); // 30 minutes

        // Send the token to the user's email
        String resetUrl = "https://example.com/reset-password?token=" + token;
        // Send an email to the user with the reset URL (implementation omitted)

        // Simulating a request with the token
        String tokenFromUrl = token; // Replace with actual request parameter handling

        if (tokenFromUrl.equals(user.getResetToken()) && System.currentTimeMillis() < user.getResetTokenExpiration()) {
            // Allow the user to reset their password
            System.out.println("Valid token, allowing password reset.");
        } else {
            // Invalid or expired token, deny access
            System.out.println("Invalid or expired token, denying access.");
        }
    }
}

class User {
    private String resetToken;
    private long resetTokenExpiration;

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public void setResetTokenExpiration(long resetTokenExpiration) {
        this.resetTokenExpiration = resetTokenExpiration;
    }

    public String getResetToken() {
        return resetToken;
    }

    public long getResetTokenExpiration() {
        return resetTokenExpiration;
    }
}