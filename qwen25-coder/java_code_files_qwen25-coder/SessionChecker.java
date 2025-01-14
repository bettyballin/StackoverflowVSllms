public class SessionChecker {
    public static void main(String[] args) {
        HttpServletRequest request = new HttpServletRequest();
        HttpSession session = request.getSession(false);
        if (session == null) {
            // No session exists for this request.
        } else {
            try {
                // Try to access any attribute from the session
                Object attribute = session.getAttribute("someAttribute");
            } catch (IllegalStateException e) {
                // This exception is thrown if you try to use a session that has already been invalidated.
                System.out.println("The session is invalid.");
            }
        }
    }

    static class HttpServletRequest {
        public HttpSession getSession(boolean create) {
            // Simulate the absence of a session
            return create ? new HttpSession() : null;
        }
    }

    static class HttpSession {
        public Object getAttribute(String name) {
            // Simulate accessing an attribute from the session
            return new Object();
        }
    }
}