import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    // Assuming you retrieve the cookie by its name
    public void removeCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie myCookie = getCookieByName(request.getCookies(), "myCookieName");

        if (myCookie != null) {
            // Set max age to 0 to remove it immediately
            myCookie.setMaxAge(0);
            myCookie.setPath("/");
            response.addCookie(myCookie);
        }
    }

    private Cookie getCookieByName(Cookie[] cookies, String name) {
        if(cookies != null){
            for (Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Main method can be used for testing if needed
    }
}