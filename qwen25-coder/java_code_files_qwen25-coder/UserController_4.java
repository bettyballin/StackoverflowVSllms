import java.util.ArrayList;
import java.util.List;

// Add imports for annotations
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Define the annotations used
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Controller {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RequestMapping {
    String value() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ResponseBody {}

@Controller
public class UserController_4 {

    @RequestMapping("/fetch-users")
    @ResponseBody
    public List<User> fetchUsers() {
        // Simulate fetching data from database
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "user1@example.com"));
        users.add(new User("user2", "user2@example.com"));
        return users;
    }

    // User class to represent user data
    public static class User {
        private String username;
        private String email;

        public User(String username, String email) {
            this.username = username;
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }

    public static void main(String[] args) {
        // You can test the fetchUsers method here if needed
    }
}