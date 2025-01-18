// Removed the imports and provided minimal implementations to make it compilable with javac.

public class SessionExample {
    public void processRequest(HttpServletRequest request) {
        HttpSession session = request.getSession();
        
        // setting value into the session
        Object myValue = new Object(); // Define myValue before setting it into the session
        session.setAttribute("myKey", myValue);
        
        // getting value from session
        Object myValueFromSession = session.getAttribute("myKey");
    }
}

// Define HttpServletRequest
class HttpServletRequest {
    private HttpSession session = new HttpSession();

    public HttpSession getSession() {
        return session;
    }
}

// Define HttpSession
class HttpSession {
    private java.util.Map<String, Object> attributes = new java.util.HashMap<>();

    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }

    public Object getAttribute(String name) {
        return attributes.get(name);
    }
}