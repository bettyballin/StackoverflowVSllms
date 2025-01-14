import java.lang.String;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class SecureCookieManager {

    public SecureCookieManager(String sessionId, HttpServletResponse response) {
        Cookie loginCookie = new Cookie("session_id", sessionId);
        loginCookie.setSecure(true);  // Ensure the cookie is only sent over HTTPS
        loginCookie.setHttpOnly(true);  // Prevent the cookie from being accessed via JavaScript
        response.addCookie(loginCookie);
    }

    public static void main(String[] args) {
    }
}