import javax.persistence.ConstraintViolationException;

public class UsernameRegistrar {
    public static void insertUsername(String username) {
        // Implement the logic to insert the username into a database or storage
        // For demonstration purposes, this method is left empty
    }

    public static void main(String[] args) {
        String username = "exampleUser";
        try {
            insertUsername(username);
        } catch (ConstraintViolationException e) {
            // Handle duplicate username
            System.out.println("Username already exists: " + e.getMessage());
        }
    }
}