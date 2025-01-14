import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class InitialSetup {

    private static final String SETUP_TOKEN = "THIS_IS_A_ONE_TIME_SETUP_TOKEN";

    public boolean isValidSetupToken(String token) {
        return SETUP_TOKEN.equals(token);
    }

    public String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encodedhash);
    }

    public void createAdminUser(User admin, String token) throws Exception {
        if (!isValidSetupToken(token)) {
            throw new SecurityException("Invalid setup token provided.");
        }
        // Assuming `admin` object includes username and password
        admin.setPassword(hashPassword(admin.getPassword()));
        saveToDatabase(admin);
        System.out.println("Admin user created successfully with hashed password.");
    }

    private void saveToDatabase(User user) {
        // Logic to securely save the user to your database.
    }

    public static void main(String[] args) {
        // Example usage
    }
}

class User {
    private String username;
    private String password;

    public User() {
        // Default constructor
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}