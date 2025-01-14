public class SessionMonitor implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {}

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        XMPPConnectionManager.removeAndDisconnect(sessionId);
    }

    public static void main(String[] args) {
    }
}

interface HttpSessionListener {
    void sessionCreated(HttpSessionEvent se);
    void sessionDestroyed(HttpSessionEvent se);
}

class HttpSessionEvent {
    public HttpSession getSession() {
        return new HttpSession();
    }
}

class HttpSession {
    public String getId() {
        return "dummySessionId";
    }
}

class XMPPConnectionManager {
    public static void removeAndDisconnect(String sessionId) {
        // Implementation here
    }
}