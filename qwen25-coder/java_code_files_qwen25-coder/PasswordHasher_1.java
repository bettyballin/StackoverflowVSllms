import java.lang.String;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher_1 {
    public static String hashPassword(String plainTextPassword) {
        // Generate the hashed password with Bcrypt, including the salt
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String candidatePassword, String hashedPassword) {
        // Check if a given password matches the hashed password
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }

	public static void main(String[] args) {
	}
}