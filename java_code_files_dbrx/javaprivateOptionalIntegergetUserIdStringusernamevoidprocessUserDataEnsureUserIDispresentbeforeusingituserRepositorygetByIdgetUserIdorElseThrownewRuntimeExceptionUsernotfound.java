import java.util.Optional;

public class UserProcessor {
    private String username = "exampleUser";

    private Optional<Integer> getUserId() { /*...*/ 
        // Simulate getting a User ID based on username
        // For demonstration, we'll return an empty Optional to mimic "User not found"
        return Optional.empty();
    }

    void processUserData() {
        // Ensure User ID is present before using it...
        UserRepository userRepository = new UserRepository();
        userRepository.getById(
            getUserId().orElseThrow(() -> new RuntimeException("User not found"))
        ).process();
    }

    public static void main(String[] args) {
        UserProcessor processor = new UserProcessor();
        processor.processUserData();
    }
}

class UserRepository {
    public User getById(int userId) {
        // Fetch user by ID
        return new User();
    }
}

class User {
    public void process() {
        // Process the user
        System.out.println("User processed.");
    }
}