import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class SessionManager_4_4 {
    public static void main(String[] args) {
        HttpServletResponse response = null; // This should be obtained from a servlet context
        Cookie cookie = createSecureCookie();
        response.addCookie(cookie);
    }

    public static Cookie createSecureCookie() {
        // Create a secure session ID
        String sessionId = UUID.randomUUID().toString();

        // Set the session ID cookie with Secure and HttpOnly flags
        Cookie cookie = new Cookie("JSESSIONID", sessionId);
        cookie.setSecure(true);
        cookie.setHttpOnly(true);

        return cookie;
    }

    // Note: The following methods require a servlet context to execute and cannot be called directly from the main method.
    // public void invalidateSession(HttpSession session) {
    //     // Invalidate the session ID after 30 minutes of inactivity
    //     session.setMaxInactiveInterval(1800);

    //     // Destroy the session ID when the user logs out
    //     session.invalidate();
    // }
}