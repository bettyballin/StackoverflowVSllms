import java.util.UUID;

// Server-side
public class LoginServer {
    public String generateChallenge() {
        // Generate a random challenge (nonce)
        return UUID.randomUUID().toString();
    }

    public boolean verifyLogin(String username, String hashedPassword, String challenge) {
        // Retrieve the user's salt and stored password
        String salt = getUserSalt(username);
        String storedPassword = getStoredPassword(username);

        // Recalculate the expected hash
        String expectedHash = Hash(storedPassword + salt + challenge);

        // Compare the expected hash with the received hash
        return expectedHash.equals(hashedPassword);
    }

    // Assuming these methods exist in the original code
    private String getUserSalt(String username) {
        // Implementation to retrieve user's salt
        return "";
    }

    private String getStoredPassword(String username) {
        // Implementation to retrieve user's stored password
        return "";
    }

    // Assuming this method exists in the original code
    private String Hash(String input) {
        // Implementation of the hash function
        return "";
    }
}

// Client-side
public class LoginClient {
    public String calculateHashedPassword(String password, String salt, String challenge) {
        // Calculate the hashed password using the password, salt, and challenge
        return Hash(password + salt + challenge);
    }

    // Assuming this method exists in the original code
    private String Hash(String input) {
        // Implementation of the hash function
        return "";
    }

    public static void main(String[] args) {
        // Create instances of the classes to make the code executable
        LoginServer server = new LoginServer();
        LoginClient client = new LoginClient();
    }
}