// Define the ValidationException class
class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

public class User_19_19 {
    private String username;

    // Change the constructor parameter type to match the class name
    public User_19(String username) {
        if (username == null || username.length() > 50) {
            throw new ValidationException("Invalid username");
        }
        this.username = username;
    }

    public static void main(String[] args) {
    }
}