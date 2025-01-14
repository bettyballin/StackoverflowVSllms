import java.lang.String;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class OfflineAuthExample {
    private static final String SALT = "your_unique_salt_here"; // Ensure this is unique and secret

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(SALT.getBytes());
        byte[] hashedBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    public boolean authenticateOffline(String enteredPassword, String storedHash) throws NoSuchAlgorithmException {
        String enteredHash = hashPassword(enteredPassword);
        return storedHash.equals(enteredHash);
    }

	public static void main(String[] args) {
	}
}