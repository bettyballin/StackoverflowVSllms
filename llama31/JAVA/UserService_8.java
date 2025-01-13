import java.util.List;

// Modular design with dependency injection
public class UserService_8 {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public static void main(String[] args) {
    }
}

// Adding the missing UserRepository class
interface UserRepository {
    List<User> findAll();
}

// Adding the missing User class
class User {
}