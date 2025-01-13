import java.lang.String;
import javax.servlet.http.HttpServletRequest;

// Custom ValidationException class
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

// User.java (Model)
class User {
    private String username;
    private String email;

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new ValidationException("Username is required");
        }
        this.username = username;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            throw new ValidationException("Invalid email address");
        }
        this.email = email;
    }
}

// UserController.java (Controller)
public class User_50Controller {
    private HttpServletRequest request;

    public UserController(HttpServletRequest request) {
        this.request = request;
    }

    public void createUser(User user) {
        try {
            user.setUsername(request.getParameter("username"));
            user.setEmail(request.getParameter("email"));
            // Save user to database
        } catch (ValidationException e) {
            // Handle validation error
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage:
        // HttpServletRequest request = ...; // obtain the HttpServletRequest object
        // UserController controller = new UserController(request);
        // User user = new User();
        // controller.createUser(user);
    }
}