import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtilorHttpServletResponseHelper {
    public static void main(String[] args) {
        HttpServletResponse response = null; // You need to get the HttpServletResponse object from somewhere, e.g., a servlet
        Cookie cookie = new Cookie("lastOpenedFile", "/path/to/file");
        cookie.setMaxAge(3600); // expires in 1 hour
        response.addCookie(cookie);
    }
}