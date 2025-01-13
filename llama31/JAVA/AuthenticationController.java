import java.lang.String;

// Define the UserNotFoundException class
class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

// Define the AuthService class
class AuthService {
    public boolean authenticate(String username, String password) throws UserNotFoundException {
        // Here you should implement your authentication logic
        // For now, just return true for demonstration purposes
        return true;
    }
}

public class AuthenticationController {
    private AuthService authService = new AuthService();

    public String login(String username, String password) {
        // Attempt to authenticate the user
        try {
            // Authenticate the user
            if (!authService.authenticate(username, password)) {
                // Return a generic error message
                return "Invalid credentials";
            }
        } catch (UserNotFoundException e) {
            // Return a generic error message
            return "Invalid credentials";
        }
        // Login successful
        return "Welcome, " + username;
    }

    public static void main(String[] args) {
        AuthenticationController controller = new AuthenticationController();
        System.out.println(controller.login("test", "test"));
    }
}