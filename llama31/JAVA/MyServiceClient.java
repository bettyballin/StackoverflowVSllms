import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Define the User class
class User {
    // Add fields and getters/setters as needed
}

// Make the interface a separate file or a static inner class
@FeignClient(name = "my-service", url = "https://api.example.com")
interface MyServiceClient {

    @GetMapping("/users/{id}")
    User getUser(@PathVariable("id") Long id);

    @PostMapping("/users")
    User createUser(@RequestBody User user);
}

public class Main {
    public static void main(String[] args) {
        // Create an instance of the client and use it
        // MyServiceClient client = ...;
        // User user = client.getUser(1L);
        // ...
    }
}