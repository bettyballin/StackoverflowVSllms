// User.java
public class User {
    private String username;
    private String email;

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

// ValidationException.java
public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

// RegistrationModule.java
public class RegistrationModule {
    public void registerUser(User user) {
        // Basic input validation
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new ValidationException("Username is required");
        }
        // ...
        RegistrationUtility.registerUser(user);
    }
}

// RegistrationUtility.java
public class RegistrationUtility {
    public static void registerUser(User user) {
        // Comprehensive validation
        if (!isValidEmail(user.getEmail())) {
            throw new ValidationException("Invalid email address");
        }
        // ...
        // Database-specific validation and insertion
    }

    private static boolean isValidEmail(String email) {
        // Basic email validation, adjust according to needs
        return email != null && email.contains("@");
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUsername("testUser");
        user.setEmail("test@example.com");

        RegistrationModule registrationModule = new RegistrationModule();
        try {
            registrationModule.registerUser(user);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }
    }
}