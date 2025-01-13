import java.util.UUID;

public class SetupTokenValidator {
    public static void main(String[] args) {
        // Generate a one-time setup token
        String setupToken = UUID.randomUUID().toString();

        // Store the setup token in a secure storage
        // ...

        // Example provided token, in real scenario it would come from user input
        String providedToken = setupToken; // or some other value for testing

        // Validate the setup token during initial configuration
        if (providedToken.equals(setupToken)) {
            System.out.println("Token is valid. Allowing configuration...");
            // Allow configuration
        } else {
            System.out.println("Token is invalid. Denying configuration...");
            // Deny configuration
        }
    }
}