public class SessionExample {
    public static void main(String[] args) {
        HttpServletRequest request = new HttpServletRequest();
        HttpSession session = request.getSession(); // retrieve current session
        session.invalidate();  // manually invoke the method to test session destroyed listener behavior
    }
}

class HttpServletRequest {
    public HttpSession getSession() {
        return new HttpSession();
    }
}

class HttpSession {
    public void invalidate() {
        // Invalidate the session
        System.out.println("Session invalidated");
    }
}