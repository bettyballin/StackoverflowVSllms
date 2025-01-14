import java.util.HashMap;
import java.util.Map;

class SessionManager_4 {
    private Map<String, String> sessionStore = new HashMap<>();

    // Method to create a session for a user
    public void createSession(String sessionId, String userId) {
        sessionStore.put(sessionId, userId);
    }

    // Method to get user ID from session ID
    public String getUserIdFromSession(String sessionId) {
        return sessionStore.get(sessionId);
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        SessionManager_4 sessionManager = new SessionManager_4();
        
        // Simulate a user login that generates a session ID
        String sessionId = "unique_session_id_123";
        String userId = "user456";
        
        // Create a session for the user
        sessionManager.createSession(sessionId, userId);
        
        // Later on, retrieve the user ID from the session ID
        String retrievedUserId = sessionManager.getUserIdFromSession(sessionId);
        
        if (retrievedUserId != null) {
            System.out.println("User is logged in: " + retrievedUserId);
            // Redirect to user-specific page or perform other actions
        } else {
            System.out.println("No user found for this session.");
        }
    }
}