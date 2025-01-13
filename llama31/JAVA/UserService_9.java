import java.lang.String;

// Good example
public class UserService_9_9 {
    private final UserRepository userRepository;

    public UserService_9(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public static void main(String[] args) {
    }
}

class UserRepository {
    public User getUser(int id) {
        // Assuming User is a class with a constructor that takes an id
        return new User(id);
    }
}

class User {
    private int id;

    public User(int id) {
        this.id = id;
    }
}