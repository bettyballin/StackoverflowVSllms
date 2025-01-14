import java.lang.String;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher_4 {
    // Hash a password for the first time
    public static String hashPassword(String plainTextPassword) {
        return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
    }

    // Check that an unencrypted password matches one that has previously been hashed
    public static boolean checkPassword(String candidatePassword, String hashedPassword) {
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }

	public static void main(String[] args) {
	}
}