// Service interface that abstracts core functionality
interface UserService {
    User getUserById(int id);
}

// User class
class User {
    private int id;
    private String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
}

// UserRepository interface
interface UserRepository {
    User findById(int id);
}

// Implementation of the service with database dependency
class UserServiceImpl_3 implements UserService {
    private final UserRepository userRepository;

    // Constructor injection for the UserRepository
    public UserServiceImpl_3(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id);
    }
}

// Mock implementation of the repository for testing
public class UserRepositoryMock implements UserRepository {
    @Override
    public User findById(int id) {
        // Mock behavior
        return new User(id, "John Doe");
    }

    public static void main(String[] args) {
        // Example usage
        UserRepositoryMock repoMock = new UserRepositoryMock();
        UserService userService = new UserServiceImpl_3(repoMock);
        User user = userService.getUserById(1);
        System.out.println("User ID: " + user.getId() + ", Name: " + user.getName());
    }
}