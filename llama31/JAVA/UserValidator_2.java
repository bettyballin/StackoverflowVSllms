import java.sql.SQLException;

// Placeholder User class
class User {
    private String email;

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}

// Placeholder UserDAO class
class UserDAO {
    public void save(User user) throws SQLException {
        // Simulate database interaction
        // For demonstration, assume this might throw SQLException
        if (user.getEmail().isEmpty()) {
            throw new SQLException("Email cannot be empty", "23514");
        }
        System.out.println("User saved successfully.");
    }
}

public class UserValidator_2_2 {
    private UserDAO userDAO = new UserDAO();

    public boolean isValidEmail(String email) {
        // Simple email validation for demonstration
        return email.contains("@");
    }

    public boolean isValidUser(User user) {
        // Validate user data using server-side logic
        if (!isValidEmail(user.getEmail())) {
            return false;
        }
        // If validation passes, attempt to persist the data
        try {
            userDAO.save(user);
            return true;
        } catch (SQLException e) {
            // Handle database constraint errors
            if (e.getSQLState().equals("23514")) { // Check constraint error
                return false;
            }
            // Handle other errors
            System.err.println("An error occurred: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        UserValidator_2 validator = new UserValidator_2();
        User user = new User("example@example.com");
        boolean isValid = validator.isValidUser(user);
        System.out.println("Is user valid? " + isValid);
    }
}