import org.passay.PasswordHash;
import org.passay.PasswordHasher;
import org.passay.PasswordHasher.DefaultPasswordHasher;

import java.security.SecureRandom;
import java.util.Arrays;

public class SecurePasswordHashing {
    private static final PasswordHasher passwordHasher = new DefaultPasswordHasher();
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String hashPassword(char[] password) {
        PasswordHash passwordHash = passwordHasher.hashPassword(password);
        return passwordHash.toString();
    }

    public static void main(String[] args) {
        char[] password = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        try {
            String hashedPassword = hashPassword(password);
            // Store the hashed password in your database
            System.out.println("Hashed password: " + hashedPassword);
        } finally {
            // Clear the password array
            Arrays.fill(password, '0');
        }
    }
}