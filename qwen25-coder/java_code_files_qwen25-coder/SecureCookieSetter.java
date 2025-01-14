import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class SecureCookieSetter {
    // Securely setting an HttpOnly cookie in Java Servlets
    public void setSecureCookie(HttpServletResponse response, String sessionId) {
        response.addCookie(new Cookie("session_id", sessionId) {{
            setHttpOnly(true);
            setSecure(true); // Ensure cookies are sent over HTTPS
        }});
    }

    public static void main(String[] args) {
        // Main method can remain empty or used for testing purposes
    }
}