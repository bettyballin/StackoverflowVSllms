import java.lang.String;
import javax.servlet.http.Cookie;
public class SecureCookieCreator {
    // Setting security for cookies in Java EE
    Cookie cookie;

    {
        String sessionId = "yourSessionId";
        cookie = new Cookie("sessionId", sessionId);
        cookie.setHttpOnly(true);  // Prevents access to the cookie via JavaScript (XSS)
        cookie.setSecure(true);     // Sends cookie only over HTTPS/HTTP2 connections
    }

    public static void main(String[] args) {
    }
}