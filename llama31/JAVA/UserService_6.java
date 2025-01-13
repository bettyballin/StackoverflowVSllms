import java.util.Optional;

// Assuming User is a custom class
class User {
    // Add properties and methods as needed
}

// Assuming UserRepository is an interface or class that extends JpaRepository
interface UserRepository {
    Optional<User> findById(Long id);
}

public class UserService_6_6 {
    private final UserRepository userRepository;

    public UserService_6(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public static void main(String[] args) {
        // Create an instance of UserRepository and UserService_6 to test
        UserRepository userRepository = new UserRepository() {
            @Override
            public Optional<User> findById(Long id) {
                // Mock implementation for testing purposes
                return Optional.empty();
            }
        };

        UserService_6 userService = new UserService_6(userRepository);
        userService.getUserById(1L); // Example usage
    }
}