public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}

public class User_3 {
    private String email;
    private String password;

    public void setEmail(String email) throws ValidationException {
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException("Invalid email format.");
        }
        this.email = email;
    }

    public void setPassword(String password) throws ValidationException {
        if (password.length() < 8) {
            throw new ValidationException("Password must be at least 8 characters long.");
        }
        this.password = password;
    }

    public static void main(String[] args) {
        // Usage in registration process and API handling
        String emailInput = "test@example.com"; // Replace with actual input
        String passwordInput = "password123";   // Replace with actual input

        try {
            User_3 user = new User_3();
            user.setEmail(emailInput);
            user.setPassword(passwordInput);
            // Proceed with adding user to database or further processing
            System.out.println("User registered successfully.");
        } catch (ValidationException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}