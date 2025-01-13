// User.java
public class User_7 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// UserService.java
public interface UserService {
    User getUser(Long id);
}

// UserServiceImpl.java
public class User_7ServiceImpl implements UserService {
    @Override
    public User getUser(Long id) {
        // Simulating a user retrieval
        User user = new User();
        user.setName("John Doe");
        return user;
    }
}

// UserController.java
import java.lang.reflect.Field;

public class User_7Controller {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public User getUser(Long id) {
        return userService.getUser(id);
    }

    public static void main(String[] args) throws Exception {
        UserService userService = new UserServiceImpl();
        UserController userController = new UserController(userService);
        User user = userController.getUser(1L);
        System.out.println(user.getName());
    }
}