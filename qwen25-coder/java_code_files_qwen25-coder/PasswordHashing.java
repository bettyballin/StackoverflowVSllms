import java.lang.String;
import java.security.SecureRandom;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    public static void main(String[] args) {
        String password = "userPassword";
        
        // Generate a random salt
        byte[] salt = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        // Hash the password with the generated salt using bcrypt
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));

        // Store `hashedPassword` in your database

        // Example of verifying the password
        String candidatePassword = "userPassword";
        boolean verified = BCrypt.checkpw(candidatePassword, hashedPassword);
        System.out.println("Password Verified: " + verified);
    }
}