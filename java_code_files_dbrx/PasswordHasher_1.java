import java.security.SecureRandom;
import java.util.Arrays;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHasher {
    public String hashPassword(final char[] passwordCharArray) {
        // Generate the salt, using a secure random number generator
        final SecureRandom random = new SecureRandom();
        final byte[] saltBytes = new byte[20];
        random.nextBytes(saltBytes);

        // Password hashing with bcrypt requires encoding 'bytes', not chars or strings, since they don't maintain character set consistency.
        String passwordHash = BCrypt.hashpw(new String(passwordCharArray), BCrypt.gensalt());

        // Clear the original password from memory immediately after obtaining hash.
        Arrays.fill(passwordCharArray, '0');

        return passwordHash;
    }
}