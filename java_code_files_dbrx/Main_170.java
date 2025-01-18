public class Main {
    public static void main(String[] args) {
        HttpSession session = new MyMockHttpSession(); // Create your mock HTTP session first
        sessionDestroyed(new HttpSessionEvent(session)); // Invoke the method manually.
    }

    // Mocking the sessionDestroyed method as per HttpSessionListener interface
    public static void sessionDestroyed(HttpSessionEvent event) {
        // Handle session destruction
        System.out.println("Session destroyed: " + event.getSession().getId());
    }
}

// Mock HttpSession interface
interface HttpSession {
    String getId();
    // Add other methods if necessary
}

// Mock HttpSessionEvent class
class HttpSessionEvent {
    private final HttpSession session;

    public HttpSessionEvent(HttpSession session) {
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }
}

// Mock MyMockHttpSession class implementing HttpSession
class MyMockHttpSession implements HttpSession {
    @Override
    public String getId() {
        return "MockSessionId";
    }
    // Implement other methods if necessary
}