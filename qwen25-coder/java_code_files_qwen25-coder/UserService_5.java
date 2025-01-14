import java.security.Principal;

// User class
public class User {
    private Long id;
    private String username;
    private boolean admin;

    public User(Long id, String username, boolean admin) {
        this.id = id;
        this.username = username;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public boolean isAdmin() {
        return admin;
    }
}

// UserRepository interface
interface UserRepository {
    User findById(Long id);
    User findByUsername(String username);
}

// HttpStatus enum
enum HttpStatus {
    OK, FORBIDDEN;
}

// ResponseEntity class
class ResponseEntity<T> {
    private T body;
    private HttpStatus statusCode;

    public ResponseEntity(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public ResponseEntity(T body, HttpStatus statusCode) {
        this.body = body;
        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public T getBody() {
        return body;
    }
}

// UserService class
public class UserService {
    private UserRepository userRepository;

    // Constructor to inject UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id, User requester) throws SecurityException {
        User user = userRepository.findById(id);
        if (!canRequesterAccess(requester, user)) {
            throw new SecurityException("Requester is not allowed to access this resource");
        }
        return user;
    }

    private boolean canRequesterAccess(User requester, User requestedUser) {
        // Implement your logic for determining if the requester can view the requestedUser's data
        return requester.getId().equals(requestedUser.getId()) || requester.isAdmin();
    }
}

// UserController class
public class UserController {
    private UserService userService;
    private UserRepository userRepository;

    // Constructor to inject dependencies
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public ResponseEntity<User> getUser(Long id, Principal principal) {
        User currentUser = getCurrentUserFromPrincipal(principal);
        try {
            User user = userService.getUser(id, currentUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (SecurityException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    private User getCurrentUserFromPrincipal(Principal principal) {
        // Get the current logged-in user from the security context
        String username = principal.getName();
        return userRepository.findByUsername(username);
    }

    public static void main(String[] args) {
        // Create a mock UserRepository
        UserRepository userRepository = new UserRepository() {
            @Override
            public User findById(Long id) {
                return new User(id, "user" + id, false);
            }

            @Override
            public User findByUsername(String username) {
                return new User(1L, username, false);
            }
        };

        // Create UserService
        UserService userService = new UserService(userRepository);

        // Create UserController
        UserController userController = new UserController(userService, userRepository);

        // Mock principal
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "user1";
            }
        };

        // Call getUser method
        ResponseEntity<User> response = userController.getUser(1L, principal);
        System.out.println("Response status: " + response.getStatusCode());
        if (response.getBody() != null) {
            System.out.println("User ID: " + response.getBody().getId());
        }
    }
}