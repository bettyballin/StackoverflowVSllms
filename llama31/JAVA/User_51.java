// User.java
public class User_51 {
    // assume this is a simple User class with some properties and getters/setters
    @Override
    public String toString() {
        return "User{}"; // Add a toString method to print a meaningful string
    }
}

// UserService.java
public class User_51Service {
    public User getCurrentUser() {
        // retrieve user from database or session
        // for simplicity, let's assume we have a dummy user
        User user = new User();
        return user;
    }
}

// UserController.java
import java.util.HashMap;
import java.util.Map;

public class User_51Controller {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public String getUser() {
        User user = userService.getCurrentUser();
        if (user != null) {
            System.out.println("User found: " + user);
            return "user";
        } else {
            System.out.println("User not found");
            return "error";
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        UserController userController = new UserController(userService);
        userController.getUser();
    }
}