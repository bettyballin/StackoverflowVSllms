import java.lang.String;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

// Commented out as @RestController is a Spring annotation
// @RestController
public class MyController {

    // Commented out as @Autowired is a Spring annotation
    // @Autowired
    private UserService userService;

    public void myMethod() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Assuming UserDetails has a method getId() which returns a Long
        Long userId = ((UserDetails) authentication.getPrincipal()).getId();

        // Assuming UserService and its method getAttachedUser are correctly defined elsewhere
        User attachedUser = userService.getAttachedUser(userId);

        // Now you can access the lazy-loaded relations of the attached user
    }

    public static void main(String[] args) {
    }
}