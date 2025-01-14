import java.lang.String;

public class UserValidator {
    // Example in Java for Module (Presentation Layer)
    public boolean validateInput(String userInput) {
        // Simple check to ensure input is not empty and follows expected format
        return userInput != null && !userInput.isEmpty() && userInput.matches("[a-zA-Z0-9]+");
    }
    
    // Example in Java for Utility (Business Logic Layer)
    public void registerUser(User user) throws IllegalArgumentException {
        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        // More validation logic as needed
        saveToDatabase(user);
    }
    
    private boolean isValidEmail(String email) {
        // Placeholder implementation
        return email.contains("@");
    }

    private void saveToDatabase(User user) {
        // Placeholder implementation
    }

    public static void main(String[] args) {
        // Example usage
        UserValidator validator = new UserValidator();
        String input = "TestUser123";
        boolean isValid = validator.validateInput(input);
        System.out.println("Is user input valid? " + isValid);
        
        User user = new User("test@example.com");
        try {
            validator.registerUser(user);
            System.out.println("User registered successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Definition of the User class
class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}