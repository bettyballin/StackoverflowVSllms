import java.lang.String;
import java.util.Set;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieManager {
    public static void main(String[] args) {
        // Create a cookie with the initial playback position (0)
        Cookie cookie = new Cookie("playbackPosition", "0");
        cookie.setMaxAge(31536000); // Set cookie to expire in 1 year
        
        // You need an HttpServletResponse object to add the cookie
        // For demonstration purposes, assume we have an HttpServletResponse object
        HttpServletResponse response = null; // You would typically get this from a servlet or similar
        
        if (response != null) {
            response.addCookie(cookie);
        } else {
            System.out.println("No HttpServletResponse object available.");
        }
    }
}