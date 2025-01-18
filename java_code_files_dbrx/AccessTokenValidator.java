public class AccessTokenValidator {
    static Session session;

    public static void main(String[] args) {
        if (!session.isOpened()) {
            session = getNewSession();
        }
        // Now you know your access token is valid and not expired! Make the call here:
        makeRequest(session);
    }

    static Session getNewSession() {
        // Implementation for obtaining a new session
        return new Session();
    }

    static void makeRequest(Session session) {
        // Implementation for making a request with the session
    }
}

class Session {
    boolean isOpened() {
        // Check if the session is opened
        return true; // or actual logic
    }
}