import org.mindrot.jbcrypt.BCrypt;

public class javaPasswordHashGenerator {
    // Generate a new random salt for a new user account
    String salt = BCrypt.gensalt(); // Generate a new unique and random salt value for each stored password hash
    public static void main(String[] args) {
    }
}