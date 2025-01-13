import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Main_583 {
    public static void main(String[] args) {
        // Generate a random token with a short expiration time
        String token = generateToken();
        String expirationTime = Instant.now().plus(15, ChronoUnit.MINUTES).toString();

        // Assuming a User class with setEmail, setValidationToken, and setValidationTokenExpiration methods
        User user = new User();
        user.setEmail("example@example.com");
        user.setValidationToken(token);
        user.setValidationTokenExpiration(expirationTime);

        // Send the validation email with the token
        sendEmail(user.getEmail(), "Validate your account", "https://example.com/validate?token=" + token);
    }

    // Assuming a method to generate a random token
    public static String generateToken() {
        // Implement your token generation logic here
        return "random-token";
    }

    // Assuming a method to send an email
    public static void sendEmail(String to, String subject, String body) {
        // Implement your email sending logic here
        System.out.println("Email sent to " + to + " with subject " + subject + " and body " + body);
    }
}

// Assuming a User class
class User {
    private String email;
    private String validationToken;
    private String validationTokenExpiration;
    private boolean active;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getValidationToken() {
        return validationToken;
    }

    public void setValidationToken(String validationToken) {
        this.validationToken = validationToken;
    }

    public String getValidationTokenExpiration() {
        return validationTokenExpiration;
    }

    public void setValidationTokenExpiration(String validationTokenExpiration) {
        this.validationTokenExpiration = validationTokenExpiration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

// Assuming a controller class for the validation endpoint
class ValidationController {
    public String validate(String token) {
        // Check if the token is valid and not expired
        if (isTokenValid(token) && !isTokenExpired(token)) {
            // Activate the user's account
            User user = new User(); // Assuming you have a way to get the user from the token
            user.setActive(true);
            return "Account validated successfully!";
        } else {
            return "Invalid or expired token.";
        }
    }

    // Assuming methods to check token validity and expiration
    public boolean isTokenValid(String token) {
        // Implement your token validation logic here
        return true;
    }

    public boolean isTokenExpired(String token) {
        // Implement your token expiration logic here
        return false;
    }
}