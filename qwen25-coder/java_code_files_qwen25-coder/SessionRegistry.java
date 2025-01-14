import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SessionRegistry implements HttpSessionListener {
    private static final Set<HttpSession> sessions = Collections.synchronizedSet(new HashSet<>());

    // To be called upon session creation
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessions.add(se.getSession());
    }

    // To be called upon session invalidation
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessions.remove(se.getSession());
    }

    // This method can be invoked whenever you need to clear a specific attribute from all sessions
    public static void invalidateAttribute(String attributeName) {
        synchronized (sessions) {
            for (HttpSession session : sessions) {
                if (session != null) {
                    session.removeAttribute(attributeName);
                }
            }
        }
    }

    public static void main(String[] args) {
    }
}

// Definitions for HttpSession, HttpSessionEvent, HttpSessionListener

interface HttpSession {
    void removeAttribute(String name);
}

class HttpSessionEvent {
    private HttpSession session;

    public HttpSessionEvent(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }
}

interface HttpSessionListener {
    void sessionCreated(HttpSessionEvent se);
    void sessionDestroyed(HttpSessionEvent se);
}