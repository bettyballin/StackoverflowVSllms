import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

// Assuming UserRepository and User are properly defined
import yourpackage.User;
import yourpackage.UserRepository;

@RestController
@RequestMapping("/users")
public class UserService_4_4 {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User getUser(@PathVariable Long id) {
    return userRepository.findById(id).orElseThrow();
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  public static void main(String[] args) {
    // For a Spring Boot application, you would typically start it differently,
    // using SpringApplication.run(UserService_4.class, args); in a main application class.
    // The main method here is left empty as this class is not designed to be the main application class.
  }
}