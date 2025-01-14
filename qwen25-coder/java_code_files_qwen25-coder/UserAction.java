// Action Level Validation using Struts2 Annotations
public class UserAction {

    // Custom annotation to simulate @RequiredStringValidator
    public @interface RequiredStringValidator {
        String message();
    }

    @RequiredStringValidator(message = "Username is required")
    private String username;

    // Constants for action results
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    // Getter and setter for 'username'
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String execute() throws Exception {
        User user = new User();
        user.setUsername(username);
        if (isValidUser(user)) {
            return SUCCESS;
        }
        return ERROR;
    }

    private boolean isValidUser(User user) {
        try {
            new UserValidator().validate(user);
        } catch (ValidationException e) {
            return false;
        }
        return true;
    }
}

// Domain Object-Level Validation
class User {

    // Custom annotation to simulate @NotNull
    public @interface NotNull {
        String message();
    }

    @NotNull(message = "Username cannot be null")
    private String username;

    // Getter and setter for 'username'
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

// Custom ValidationException class
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

class UserValidator {
    public void validate(User user) throws ValidationException {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new ValidationException("Invalid username");
        }
        // Add more validation rules as needed
    }

    public static void main(String[] args) {
        // For testing purposes
        UserAction action = new UserAction();
        action.setUsername("testUser");
        try {
            System.out.println(action.execute());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}