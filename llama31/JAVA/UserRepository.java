import java.lang.String;

// Define the User class
class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

// Define the ValidationException class
class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class UserRepository {
    public void saveUser(User user) {
        if (user.getUsername().length() > getMaxUsernameLength()) {
            throw new ValidationException("Username exceeds max length");
        }
        // Save user to database
    }

    private int getMaxUsernameLength() {
        // Return max username length based on database schema
        return 255; // Assuming max username length is 255 for example purposes
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        User user = new User("example_username");
        try {
            userRepository.saveUser(user);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}