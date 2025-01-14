import java.util.List;

@Service
public class UserService_9 {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        // Business logic before saving the user can go here
        userRepository.save(user);
        return user;
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public static void main(String[] args) {
    }
}

/* Define minimal classes and annotations to make the code compile */

class User {
    // Necessary fields and methods
}

interface UserRepository {
    void save(User user);
    List<User> findAll();
}

// Define minimal annotation interfaces
@interface Service {
}

@interface Autowired {
}

@interface Transactional {
    boolean readOnly() default false;
}