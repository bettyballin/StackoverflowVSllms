import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public boolean saveUser(User user) {
        if (userValidator.isValid(user)) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
    }
}

interface UserService {
    List<User> getAllUsers();
    User getUserById(int userId);
    boolean saveUser(User user);
    boolean deleteUser(int userId);
}

interface UserRepository {
    List<User> findAll();
    Optional<User> findById(int userId);
    boolean existsById(int userId);
    void save(User user);
    void deleteById(int userId);
}

interface UserValidator {
    boolean isValid(User user);
}

class User {
    // User properties and methods
}