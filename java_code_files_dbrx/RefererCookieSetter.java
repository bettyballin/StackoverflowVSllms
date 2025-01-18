import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class RefererCookieSetter {
    // Creating the cookie with a path of "/" will make it available on all pages across your website.
    public void refererCookieSetter(HttpServletResponse httpResponse, String userRefererURL) {
        Cookie refererCookie = new Cookie("referer", userRefererURL);
        refererCookie.setPath("/"); // Set the path to root
        httpResponse.addCookie(refererCookie);
    }
    
    public static void main(String[] args) {
    }
}