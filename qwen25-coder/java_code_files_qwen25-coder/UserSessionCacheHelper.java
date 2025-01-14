import java.util.HashMap;
import java.util.Map;

public class UserSessionCacheHelper {

    public static void main(String[] args) {
        // Assuming userId is defined
        int userId = 1; // Placeholder

        // Fetch user from database
        User user = fetchUserFromDatabase(userId);

        // Create a request object
        HttpServletRequest request = new HttpServletRequest();

        // Get session from request
        HttpSession session = request.getSession();

        // Storing an object in session
        session.setAttribute("cachedUser", user);

        // Retrieving an object from session
        User cachedUser = (User) session.getAttribute("cachedUser");
        if (cachedUser == null) {
            // Fetch user again if not found in session
            cachedUser = fetchUserFromDatabase(userId);
            session.setAttribute("cachedUser", cachedUser);
        }
    }

    // Define fetchUserFromDatabase method
    public static User fetchUserFromDatabase(int userId) {
        // Placeholder implementation
        return new User(userId, "User" + userId);
    }
}

// Define User class
class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Define HttpSession class
class HttpSession {
    private Map<String, Object> attributes = new HashMap<String, Object>();

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}

// Define HttpServletRequest class
class HttpServletRequest {
    private HttpSession session = new HttpSession();

    public HttpSession getSession() {
        return session;
    }
}