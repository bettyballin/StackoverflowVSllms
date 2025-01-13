import java.util.Date;
import java.util.UUID;

public class PasswordResetService_1_1 {
    // Generate a random token
    String token = UUID.randomUUID().toString();

    // Assuming user is an object of a class with methods setPasswordResetToken and setPasswordResetTokenExpiration
    private User user = new User();

    public PasswordResetService_1() {
        // Store the token in the user's account
        user.setPasswordResetToken(token);
        user.setPasswordResetTokenExpiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000)); // 30 minutes

        // Send the token to the user's email address
        sendEmail(user.getEmail(), "Password Reset", "https://example.com/reset-password?token=" + token);
    }

    // Assuming sendEmail is a method that sends an email
    private void sendEmail(String email, String subject, String body) {
        // Implement email sending logic here
        System.out.println("Email sent to " + email + " with subject " + subject + " and body " + body);
    }

    public static void main(String[] args) {
        new PasswordResetService_1();
    }
}

class User {
    private String email;
    private String passwordResetToken;
    private Date passwordResetTokenExpiration;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public Date getPasswordResetTokenExpiration() {
        return passwordResetTokenExpiration;
    }

    public void setPasswordResetTokenExpiration(Date passwordResetTokenExpiration) {
        this.passwordResetTokenExpiration = passwordResetTokenExpiration;
    }
}