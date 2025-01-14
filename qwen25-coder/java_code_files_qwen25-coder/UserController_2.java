import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController_2 {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @Caching(evict = { @CacheEvict(value = "users", allEntries = true) })
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    public static void main(String[] args) {
    }
}

// Placeholder class for User
class User {
    // Add user properties and methods here
}

// Placeholder class for UserService
class UserService {
    public User findById(Long id) {
        // Dummy implementation
        return new User();
    }

    public User saveUser(User user) {
        // Dummy implementation
        return user;
    }
}