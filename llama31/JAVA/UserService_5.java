import java.lang.String;

// UserService.java
public class UserService_5_5 {
    private UserRepository userRepository;

    public UserService_5(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ValidationException("Name is required");
        }
        // Other validation rules...

        userRepository.save(user);
    }

    public static void main(String[] args) {
    }
}

// UserRepository.java
interface UserRepository {
    void save(User user);
}

// User.java
class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// ValidationException.java
class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}