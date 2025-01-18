import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class SessionExpirationCookieHandler {
    public static void main(String[] args) {
        // Main method left empty as per the code
    }

    public void setSessionExpiration(HttpServletRequest req, HttpServletResponse servletResponse) {
        req.getSession().setMaxInactiveInterval(60); // Sets session timeout interval in minutes (example set for 1 hour)
        Cookie cookie = new Cookie("JSESSIONID", req.getSession().getId());
        cookie.setPath("/"); // Set the path to cover all subdirectories and context paths
        servletResponse.addCookie(cookie);
    }
}