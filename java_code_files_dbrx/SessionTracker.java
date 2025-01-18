public class SessionTracker implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se){ /* handle the 'session created' event */ }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // This is where you handle any tasks when a session gets destroyed or invalidated.
        HttpSession session = se.getSession();
        User user = (User) session.getAttribute("user");  // assuming "user" was stored in the session
        /* Use JDBC/ORM to store 'user' details into your database */
    }

    public static void main(String[] args) {
    }
}

// Interface definitions
interface HttpSessionListener {
    void sessionCreated(HttpSessionEvent se);
    void sessionDestroyed(HttpSessionEvent se);
}

class HttpSessionEvent {
    private final HttpSession session;

    public HttpSessionEvent(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }
}

interface HttpSession {
    Object getAttribute(String name);
}

class User {
    // User properties and methods
}