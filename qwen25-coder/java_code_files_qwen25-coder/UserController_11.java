import java.lang.String;
import java.util.Optional;

// Dummy annotations to satisfy the compiler
@interface RestController {}
@interface RequestMapping {
    String value() default "";
}
@interface GetMapping {
    String value() default "";
}
@interface Autowired {}
@interface PathVariable {}

// Example of a Spring Boot controller method returning user information as JSON
@RestController
@RequestMapping("/api/user")
public class UserController_11 {

    @Autowired
    private UserRepository userRepository = new UserRepositoryImpl(); // Simulated autowiring for testing

    @GetMapping("/{id}")
    public ResponseEntity<UserProfile> getUserProfile(@PathVariable Long id) {
        UserProfile userProfile = userRepository.findById(id)
            .map(user -> new UserProfile(user.getName(), user.getEmail()))
            .orElseThrow(() -> new UserNotFoundException("User not found"));

        return ResponseEntity.ok(userProfile);
    }

    public static void main(String[] args) {
        UserController_11 controller = new UserController_11();
        ResponseEntity<UserProfile> response = controller.getUserProfile(1L);
        UserProfile profile = response.body;
        System.out.println("Name: " + profile.name);
        System.out.println("Email: " + profile.email);

        try {
            response = controller.getUserProfile(2L);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}

class UserProfile {
    public String name;
    public String email;

    public UserProfile(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters can be added if needed
}

class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class User {
    private String name;
    private String email;

    // Constructor, getters, and setters
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() { return name; }
    public String getEmail() { return email; }
}

class ResponseEntity<T> {
    public T body;

    private ResponseEntity(T body) {
        this.body = body;
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body);
    }
}

interface UserRepository {
    Optional<User> findById(Long id);
}

class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<User> findById(Long id) {
        // Return dummy data for testing
        if (id == 1L) {
            return Optional.of(new User("John Doe", "john@example.com"));
        } else {
            return Optional.empty();
        }
    }
}