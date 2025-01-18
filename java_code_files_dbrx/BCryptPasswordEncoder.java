import java.lang.String;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordEncoder {
    String password = "your_password_here";
    String userSuppliedPassword = "user_input_password_here";
    String secureHash; // Generate a hashed value with salt; this can be safely stored in your database.
    boolean isValidPassword; // Validate the user's given password against their previously saved hash (including its unique associated salt).

    public BCryptPasswordEncoder() {
        secureHash = BCrypt.hashpw(password, BCrypt.gensalt());
        isValidPassword = BCrypt.checkpw(userSuppliedPassword, secureHash);
    }

    public static void main(String[] args) {
        new BCryptPasswordEncoder();
    }
}