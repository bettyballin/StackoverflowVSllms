import java.lang.String;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/users")
public class UserController_10 {

    @PostMapping("/")
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        // Process the request here
        return ResponseEntity.ok("User created successfully");
    }

    public static void main(String[] args) {
    }
}

class User {
    // Define User properties and methods here
}