import java.lang.String;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class SecureCookieGenerator {

    public static void main(String[] args) {
        String sessionId = "session123";
        Cookie cookie = new Cookie("session", sessionId);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        HttpServletResponse response = null; // Placeholder for the response object
        response.addCookie(cookie);
    }
}