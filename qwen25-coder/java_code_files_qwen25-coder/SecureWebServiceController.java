import java.lang.String;

public class SecureWebServiceController {
    // Example of secure web service interaction

    private UserService userService;
    private UserRepository userRepository;

    public SecureWebServiceController() {
        userService = new UserService();
        userRepository = new UserRepository();
    }

    public String getUserData(String userId) {
        // Authenticate user
        if (!userService.authenticate(userId)) {
            throw new SecurityException("Unauthorized");
        }
        // Access data via a secure API
        return userRepository.getUserInfoSecurely(userId);
    }

    public static void main(String[] args) {
        SecureWebServiceController controller = new SecureWebServiceController();
        String userData = controller.getUserData("exampleUserId");
        System.out.println(userData);
    }
}

class UserService {
    public boolean authenticate(String userId) {
        // Authentication logic (stubbed)
        return true;
    }
}

class UserRepository {
    public String getUserInfoSecurely(String userId) {
        // Data retrieval logic (stubbed)
        return "Secure data for user: " + userId;
    }
}