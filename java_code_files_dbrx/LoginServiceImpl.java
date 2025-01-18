import java.util.Map;
import java.util.HashMap;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
    private static final String USERNAME = "USERNAME";
    private static final Map<String, User> authorizedUsers = new HashMap<>(); // This map stores valid usernames and hashed passwords
    // Add predefined users to this collection here

    public boolean authenticateUser(String username, String password) {
        if (authorizedUsers.containsKey(username)) {
            final User storedUser = authorizedUsers.get(username);
            // Here we suppose that you have your own function which checks entered password against hashed one in DB or so
            boolean isPasswordCorrect = userHasValidCredentials();
            return isPasswordCorrect && checkIfSessionIsValid(storedUser.getName());
        } else {
            throw new IllegalArgumentException("Invalid username.");
        }
    }

    public boolean checkIfSessionIsValid(String sessionId) {
        HttpSession session = this.getThreadLocalRequest().getSession(); // Get current active user's session
        if (session != null) {
            String clientSessionID = session.getId(); // Retrieve currently set JSESSIONID from server-side code using request object
            return checkIfSessionIsValidOnClient(clientSessionID);
        } else {
            return false;  // Session is not found, create a new one.
        }
    }

    private boolean checkIfSessionIsValidOnClient(String sessionId) {
        final User validUser = authorizedUsers.get("USERNAME"); // Get the client who owns this session currently
        if (validUser != null) {
            return true;   // Session is valid and owned by authenticated user
        } else {
            throw new SecurityException("Invalid Authentication: Access denied for current session.");
        }
    }

    private boolean userHasValidCredentials() {
        // Implement the logic to check user's credentials.
        return true;
    }

    public static void main(String[] args) {
    }
}

class RemoteServiceServlet {
    protected HttpServletRequest getThreadLocalRequest() {
        return new HttpServletRequest();
    }
}

interface LoginService {
    // Define method signatures as needed
}

class User {
    public String getName() {
        return "";
    }
}

class HttpSession {
    public String getId() {
        return "";
    }
}

class HttpServletRequest {
    public HttpSession getSession() {
        return new HttpSession();
    }
}