import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Define a user object
class User {
  private Long id;
  private String name;
  
  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }
  
  public Long getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
}

// Define a resource
@RestController
@RequestMapping("/users")
@SpringBootApplication
public class UserController_5_5 {
  
  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    // Return a user object
    return ResponseEntity.ok(new User(id, "John Doe"));
  }

  public static void main(String[] args) {
    SpringApplication.run(UserController_5.class, args);
  }
}