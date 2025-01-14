public @interface Service {}
public @interface Autowired {}
public @interface PersistenceContext {}
public @interface RestController {}
public @interface GetMapping {
    String value() default "";
}

@Service
class UserService_6 {

    @Autowired
    public UserDAO userDAO;

    @PersistenceContext
    public EntityManager entityManager; // or use HibernateTemplate

    public User getFullUserDetails() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) auth.getPrincipal()).getUsername();

        // Load the user using DAO which detaches the object
        User detachedUser = userDAO.findUserByUsername(username);

        // Reattach user and initialize lazy collections/collections fields if needed
        User fullUser = entityManager.merge(detachedUser);
        
        // Alternatively, reattach and manually fetch or use JPQL/HQL to load with eagerly fetching if performance is critical
        
        return fullUser;
    }
}

class UserDAO {
    public User findUserByUsername(String username) {
        return new User(username);
    }
}

class EntityManager {
    public User merge(User user) {
        return user;
    }
}

class Authentication {
    public Object getPrincipal() {
        return new UserDetails("testuser");
    }
}

class SecurityContextHolder {
    public static SecurityContext getContext() {
        return new SecurityContext();
    }
}

class SecurityContext {
    public Authentication getAuthentication() {
        return new Authentication();
    }
}

class UserDetails {
    private String username;

    public UserDetails(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String toString() {
        return "User(username=" + username + ")";
    }
}

@RestController
public class UserController {

    @Autowired
    public UserService_6 userService;

    @GetMapping("/user-details")
    public User getUserDetails() {
        return userService.getFullUserDetails();
    }

    public static void main(String[] args) {
        // Instantiate the controller (which would usually be done by the Spring framework)
        UserController controller = new UserController();

        // Instantiate the service and inject it
        controller.userService = new UserService_6();

        // Also inject the dependencies for UserService_6
        controller.userService.userDAO = new UserDAO();
        controller.userService.entityManager = new EntityManager();

        User userDetails = controller.getUserDetails();
        System.out.println("User Details: " + userDetails);
    }
}