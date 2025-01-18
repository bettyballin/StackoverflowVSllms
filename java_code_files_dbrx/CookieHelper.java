import java.lang.String;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class CookieHelper {

    public CookieHelper() {
        HttpServletResponse reply = getHttpServletResponse(); // Retrieve response object from the request context
        Cookie cookie = new Cookie("key", "value"); // Create an instance of a session-stored cookie
        reply.addCookie(cookie); // Adding the created cookie into the HTTP Response header
    }

    public HttpServletResponse getHttpServletResponse() {
        // Implement this method to retrieve the current HttpServletResponse
        return null; // Placeholder implementation
    }

    public static void main(String[] args) {
    }

}