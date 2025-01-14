import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

    public String authenticateUser(String login, String password) {
        // Authenticate user against the database
        if (isValidUser(login, password)) {
            // Get session or create a new one
            HttpSession session = getThreadLocalRequest().getSession(true);
            
            // Store user information in the session
            session.setAttribute("user", login);

            // Return the session ID
            return session.getId();
        } else {
            throw new IllegalArgumentException("Invalid username or password");
        }
    }

    private boolean isValidUser(String username, String password) {
        // Implement your authentication logic here (e.g., check against a database)
        return "admin".equals(username) && "password".equals(password);
    }

    public Boolean checkIfSessionIsValid(String sessionId) {
        HttpSession session = getThreadLocalRequest().getSession(false);
        
        // Check if the current session ID matches
        if (session != null && session.getId().equals(sessionId)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // You can add some test code here if needed
    }
}

// Interface definition for LoginService
interface LoginService {
    String authenticateUser(String login, String password);
    Boolean checkIfSessionIsValid(String sessionId);
}

// Mock implementation of RemoteServiceServlet
class RemoteServiceServlet {
    protected HttpServletRequest getThreadLocalRequest() {
        return new HttpServletRequest();
    }
}

// Simplified HttpServletRequest class
class HttpServletRequest {
    private HttpSession session;

    public HttpSession getSession(boolean create) {
        if (session == null && create) {
            session = new HttpSession();
        }
        return session;
    }
}

// Simplified HttpSession class
class HttpSession {
    private Map<String, Object> attributes = new HashMap<>();
    private String id = UUID.randomUUID().toString();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public String getId() {
        return id;
    }
}