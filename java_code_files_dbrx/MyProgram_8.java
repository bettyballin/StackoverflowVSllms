import org.mindrot.jbcrypt.BCrypt;

// Hash a password
public class MyProgram {
    public static void main(String[] args) {
        String salt = BCrypt.gensalt(); // Generate a random salt for a new user account
        String hash = BCrypt.hashpw("userpassword", salt); // Hash the password with bcrypt using the generated salt
    }
}