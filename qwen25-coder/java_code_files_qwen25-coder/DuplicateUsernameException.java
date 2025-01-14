import java.lang.String;
import java.sql.SQLException;
import java.util.logging.Logger;

// Define a Business Layer Exception
public class DuplicateUsernameException extends RuntimeException {
    public DuplicateUsernameException(String message) {
        super(message);
    }
}

// Define User class
class User {
    // For compilation purposes, leave empty or add necessary fields
}

// Define Session class with save method
class Session {
    public void save(User user) throws ConstraintViolationException {
        // Simulate operation
        // For testing purposes, you can throw an exception here if needed
        // throw new ConstraintViolationException("Constraint violation", new SQLException("duplicate entry"));
    }
}

// Define ConstraintViolationException class
class ConstraintViolationException extends Exception {
    private SQLException sqlException;

    public ConstraintViolationException(String message, SQLException sqlException) {
        super(message);
        this.sqlException = sqlException;
    }

    public SQLException getSQLException() {
        return sqlException;
    }
}

// In the UserDAO or UserService
class UserService {

    private Session session = new Session();

    public void createUser(User user) throws DuplicateUsernameException {
        try {
            // Hibernate save operation
            session.save(user);
        } catch (ConstraintViolationException e) {
            if (isDuplicateName(e)) {
                throw new DuplicateUsernameException("User name already exists.");
            }
            // Re-throw other types of ConstraintViolationException or wrap as needed
            throw new RuntimeException("An error occurred while creating user.", e);
        } catch (Exception e) {
            // Handle or re-package Hibernate-specific exceptions
            throw new RuntimeException("An unexpected error occurred", e);
        }
    }

    private boolean isDuplicateName(ConstraintViolationException e) {
        // Implement logic to determine if the exception was due to a duplicate name
        return e.getSQLException().getMessage().contains("duplicate");
    }
}

// In the Struts2 Action Layer
public class UserAction {

    private UserService userService = new UserService();
    private User user = new User();
    private String successMessage;
    private String errorMessage;

    private static final String SUCCESS = "success";
    private static final String INPUT = "input";
    private static final String ERROR = "error";

    private static final Logger log = Logger.getLogger(UserAction.class.getName());

    public String createUser() {
        try {
            userService.createUser(user);
            successMessage = "User created successfully.";
            return SUCCESS;
        } catch (DuplicateUsernameException e) {
            errorMessage = e.getMessage();
            return INPUT; // Return to form for retry
        } catch (RuntimeException e) {
            // Log the error and return an error page
            log.severe("Error creating user: " + e);
            errorMessage = "An unexpected error occurred. Please try again later.";
            return ERROR;
        }
    }

    public static void main(String[] args) {
        // For testing
        UserAction action = new UserAction();
        String result = action.createUser();
        System.out.println("Result: " + result);
    }
}