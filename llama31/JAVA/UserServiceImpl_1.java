import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Assuming User and UserRepository classes are defined elsewhere in the project
class User {
    // User class implementation
}

interface UserRepository {
    // UserRepository interface implementation
}

// Service interface
public interface UserService {
    User getUser(Long id);
}

// Service implementation
@Service
public class UserServiceImpl_1_1 implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}

// RESTful API
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    public static void main(String[] args) {
    }
}