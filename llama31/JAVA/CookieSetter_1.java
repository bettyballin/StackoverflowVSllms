import javax.servlet.http.Cookie;

public class CookieSetter_1_1 {
    public static void main(String[] args) {
        Cookie cookie = new Cookie("cookie_name", "value");
        cookie.setHttpOnly(true);
    }
}