import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieUtil {
    public DeleteCookieUtil(HttpServletResponse response) {
        // Delete the same cookie by setting max age to 0 or negative
        Cookie myCookie = new Cookie("myParameter", null);
        myCookie.setMaxAge(0); // Set the expiration date in the past
        response.addCookie(myCookie);
    }

    public static void main(String[] args) {
    }
}