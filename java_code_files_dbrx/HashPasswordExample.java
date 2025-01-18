import java.security.SecureRandom;
import org.mindrot.jbcrypt.BCrypt;

public class HashPasswordExample {
    public static void main(String[] args) {
        String plainTextPassword = "passwordToHash";
        // Generate a random, unique salt for each password (e.g., with SecureRandom)
        SecureRandom secureRandom = new SecureRandom();
        int costFactor = 12; // Higher cost factors make it more resistant to brute force attacks but increase the time required for hashing
        
        // Hash the password using bcrypt:
        String hashedPassword = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(costFactor, secureRandom));

        System.out.println("Hashed Password: " + hashedPassword);
    }
}