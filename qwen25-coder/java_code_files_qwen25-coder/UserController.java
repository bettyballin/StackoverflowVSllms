// Minimal definitions for annotations and classes
@interface RestController {}
@interface RequestMapping {
    String value();
}
@interface GetMapping {
    String value();
}
@interface PathVariable {}

class ResponseEntity<T> {
    private T body;

    private ResponseEntity(T body) {
        this.body = body;
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<>(body);
    }
}

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService = new UserService();

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Fetch user logic here
        User user = userService.getUser(id);
        return ResponseEntity.ok(user);
    }

    public static void main(String[] args) {
        // Example usage
        UserController controller = new UserController();
        ResponseEntity<User> response = controller.getUserById(1L);
        System.out.println("User fetched successfully");
    }
}

class User {
    // User fields and methods
}

class UserService {
    public User getUser(Long id) {
        return new User();
    }
}