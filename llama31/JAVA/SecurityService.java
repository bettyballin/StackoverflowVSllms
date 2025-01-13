import java.lang.String;

// User.java (added this class as it was missing)
class User {
    // Add properties and methods as needed
}

// SecurityService.java
public class SecurityService {
    public boolean hasAccess(User user, String resource) {
        // Implement access control logic here
        // For now, just return true for demonstration purposes
        return true;
    }
}

// MyController.java
import org.springframework.beans.factory.annotation.Autowired;

public class MyController {
    @Autowired
    private SecurityService securityService;

    public void handleRequest(User user, String resource) {
        if (securityService.hasAccess(user, resource)) {
            // Allow access
            System.out.println("Access granted");
        } else {
            // Deny access
            System.out.println("Access denied");
        }
    }

    public static void main(String[] args) {
        // Create instances of User and SecurityService for demonstration purposes
        User user = new User();
        SecurityService securityService = new SecurityService();
        MyController myController = new MyController();
        myController.securityService = securityService; // Inject SecurityService instance

        // Call handleRequest method
        myController.handleRequest(user, "someResource");
    }
}