/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.Cookie
 */
import javax.servlet.http.Cookie;

public class CookieUtilorHttpServletResponseHelper {
    public static void main(String[] stringArray) {
        Object var1_1 = null;
        Cookie cookie = new Cookie("lastOpenedFile", "/path/to/file");
        cookie.setMaxAge(3600);
        var1_1.addCookie(cookie);
    }
}
