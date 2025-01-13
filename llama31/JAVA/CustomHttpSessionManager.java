import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

// Custom HttpSessionManager to manage all active sessions
public class CustomHttpSessionManager implements HttpSessionManager {
    private Map<String, HttpSession> activeSessions = new ConcurrentHashMap<>();

    @Override
    public HttpSession createSession(String sessionId) {
        HttpSession session = new HttpSession(sessionId);
        activeSessions.put(sessionId, session);
        return session;
    }

    @Override
    public void removeSession(String sessionId) {
        activeSessions.remove(sessionId);
    }

    public void cleanSessionAttributes() {
        for (HttpSession session : activeSessions.values()) {
            session.removeAttribute("attributeName");
        }
    }

    public static void main(String[] args) {
    }
}

// Added HttpSession and HttpSessionManager interfaces for compilation
interface HttpSession {
    HttpSession(String sessionId);
    void removeAttribute(String attributeName);
}

interface HttpSessionManager {
    HttpSession createSession(String sessionId);
    void removeSession(String sessionId);
}