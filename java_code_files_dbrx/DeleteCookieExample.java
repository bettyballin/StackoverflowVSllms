import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookieExample {
    public void deleteCookie(HttpServletResponse response) {
        Cookie delCookie = new Cookie("cookieName", null);            // make sure the path is the same as the one used to set the original cookie. The second parameter is the value for the cookie, we will use NULL here if you want to delete it
        delCookie.setMaxAge(0);                     // Setting this age less than 0 effectively deletes the persistent cookie in browser memory
        response.addCookie(delCookie);              // add cookie into response
    }
}