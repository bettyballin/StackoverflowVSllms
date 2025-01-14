import java.lang.String;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public static void main(String[] args) {
        String password = "mysecretpassword";
        
        // Hash the password
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
        
        // Check the password against the hash
        if (BCrypt.checkpw(password, hashedPassword)) {
            System.out.println("It matches");
        } else {
            System.out.println("It does not match");
        }
    }
}