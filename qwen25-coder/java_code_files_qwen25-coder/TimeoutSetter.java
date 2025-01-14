public class TimeoutSetter {
    // Example in Java to set a timeout

    public static void main(String[] args) {
        Request request = new Request();
        request.getSession().setMaxInactiveInterval(1200); // 20 minutes
    }
}

class Request {
    public Session getSession() {
        return new Session();
    }
}

class Session {
    public void setMaxInactiveInterval(int interval) {
        // Implementation here
    }
}