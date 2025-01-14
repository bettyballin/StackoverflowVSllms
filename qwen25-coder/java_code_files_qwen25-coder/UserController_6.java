import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class UserController_6 {

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // Here you would handle saving the user, e.g., to a database.
        return ResponseEntity.ok("User created: " + user.getName() + " " + user.getSurname());
    }

    public static void main(String[] args) {
        // Your code to run the application
    }
}

// Dummy User class
class User {
    private String name;
    private String surname;

    public User() {
        // Default constructor
        this.name = "John";
        this.surname = "Doe";
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}

// Dummy annotations to allow compilation without Spring framework

@interface RestController {}

@interface RequestMapping {
    String value();
}

@interface PostMapping {
    String value();
}

@interface RequestBody {}

// Dummy ResponseEntity class
class ResponseEntity<T> {
    private T body;

    private ResponseEntity(T body) {
        this.body = body;
    }

    public static <T> ResponseEntity<T> ok(T body) {
        return new ResponseEntity<T>(body);
    }
}