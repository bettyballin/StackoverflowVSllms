import java.util.HashMap;

// Mock HttpSession class
class HttpSession {
    private HashMap<String, Object> attributes = new HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    public void invalidate() {
        attributes.clear();
    }
}

// Mock HttpServletRequest class
class HttpServletRequest {
    private HttpSession session;

    public HttpSession getSession() {
        if (session == null) {
            session = new HttpSession();
        }
        return session;
    }
}

public class SessionManager_5_5 {
    public static void main(String[] args) {
        HttpServletRequest request = new HttpServletRequest();
        HttpSession session = request.getSession();

        // Store data in session
        session.setAttribute("username", "johnDoe");

        // Get data from session
        String username = (String) session.getAttribute("username");
        System.out.println("Username: " + username);

        // Remove data from session
        session.removeAttribute("username");

        // Invalidate session
        session.invalidate();
    }
}