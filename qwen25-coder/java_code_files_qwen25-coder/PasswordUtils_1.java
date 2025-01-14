import java.lang.String;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils_1 {
    // Checkpw checks that a plaintext password matches a hashed password.
    public static boolean checkPassword(String candidate, String storedHash) {
        return BCrypt.checkpw(candidate, storedHash);
    }

    // Hash a password with bcrypt
    public static String hashPassword(String plainTextPassword){
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

	public static void main(String[] args) {
	}
}