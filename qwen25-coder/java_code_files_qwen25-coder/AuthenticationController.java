import java.util.HashMap;
import java.util.Map;

public class AuthenticationController {

    private final Map<Integer, String> userToServerMapping; // Mock database for user-server mapping

    public AuthenticationController() {
        this.userToServerMapping = new HashMap<>();
        // Populate with actual data from your master DB
        userToServerMapping.put(100, "http://honolulu.mysite.com");
        userToServerMapping.put(200, "http://tokyo.mysite.com");

        // ... more mappings ...
    }

    public String handleLogin(int userId, String password) {
        if (authenticateUser(userId, password)) { // Mock authentication method
            return userToServerMapping.getOrDefault(userId, "/login?error=invalidUserId");
        }
        return "/login?error=authenticationFailed";
    }

    private boolean authenticateUser(int userId, String password) {
        // Replace with actual authentication logic that includes checking against the master DB
        return true; // Mock result
    }

    public static void main(String[] args) {
    }
}