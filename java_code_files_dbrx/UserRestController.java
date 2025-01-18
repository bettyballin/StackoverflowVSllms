import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

@RestController
public class UserRestController {
    @GetMapping("/user")
    public ResponseEntity<User> getUser() throws Exception{
        // Fetch data from database.
        User user = new User("John", "Doe");
        return ResponseEntity.ok(user);
    }

    public static void main(String[] args) {
    }
}

class User {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters (if needed)
}