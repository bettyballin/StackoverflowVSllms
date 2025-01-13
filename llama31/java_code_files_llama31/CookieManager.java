/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 */
import javax.servlet.http.Cookie;

public class CookieManager {
    public static void main(String[] stringArray) {
        Cookie cookie = new Cookie("playbackPosition", "0");
        cookie.setMaxAge(31536000);
        Object var2_2 = null;
        if (var2_2 != null) {
            var2_2.addCookie(cookie);
        } else {
            System.out.println("No HttpServletResponse object available.");
        }
    }
}
