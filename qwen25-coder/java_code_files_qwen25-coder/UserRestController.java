// Simple example of a REST endpoint using Spring Boot
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class UserRestController {
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        return "User with ID: " + id;
    }
}