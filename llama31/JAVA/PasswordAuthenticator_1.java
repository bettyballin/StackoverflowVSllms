import org.mindrot.jbcrypt.BCrypt;

public class PasswordAuthenticator_1_1 {
    public static void main(String[] args) {
        // Use a secure password hashing algorithm
        String passwordHash = BCrypt.hashpw("password123", BCrypt.gensalt());

        // Verify user credentials
        if (BCrypt.checkpw("password123", passwordHash)) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
}