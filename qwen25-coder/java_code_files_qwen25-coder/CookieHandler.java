import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieHandler {

    public static void main(String[] args) {
        // Create a new cookie
        Cookie myCookie = new Cookie("myCookieName", "cookieValue");

        // Set the path to root, so it's accessible throughout the entire web application
        myCookie.setPath("/");

        // Optionally, if you want to restrict the domain
        myCookie.setDomain("example.com");

        // Set max age (in seconds), for example, 30 minutes
        myCookie.setMaxAge(30 * 60);

        // Add cookie to response
        HttpServletResponse response = null; // You would typically get this from the servlet context
        response.addCookie(myCookie);
    }
}