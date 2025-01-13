import javax.servlet.http.HttpSession;

public class SessionTimeoutChecker {
    public static void main(String[] args) {
        // You need an HttpServletRequest object to get the HttpSession
        // For simplicity, let's assume you have it
        // HttpServletRequest request = ...;

        HttpSession session = null; // You need to get it from HttpServletRequest
        if (session != null) {
            if (System.currentTimeMillis() - session.getLastAccessedTime() > session.getMaxInactiveInterval() * 1000) {
                System.out.println("Session is timed out");
            }
        } else {
            System.out.println("Session is null");
        }
    }
}