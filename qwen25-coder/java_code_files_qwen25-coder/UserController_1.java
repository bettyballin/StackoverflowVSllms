import java.lang.String;

@RestController
public class UserController_1 {

    @Autowired
    private UserService userService;

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    public static void main(String[] args) {
    }
}

@interface RestController {
}

@interface GetMapping {
    String value() default "";
}

@interface PathVariable {
}

@interface Autowired {
}

class ResponseEntity<T> {
    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<T>();
    }
    public static <T> ResponseEntity<T> notFound() {
        return new ResponseEntity<T>();
    }
    public ResponseEntity<T> build() {
        return this;
    }
}

class UserService {
    public User findById(Long id) {
        return new User();
    }
}

class User {
}