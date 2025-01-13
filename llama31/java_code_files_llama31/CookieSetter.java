/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 */
import javax.servlet.http.Cookie;

public class CookieSetter {
    public static void main(String[] stringArray) {
        String string = "https://example.com";
        Object var2_2 = null;
        Cookie cookie = new Cookie("refererUrl", string);
        cookie.setPath("/");
        if (var2_2 != null) {
            var2_2.addCookie(cookie);
        } else {
            System.out.println("No HttpServletResponse object available.");
        }
    }
}
