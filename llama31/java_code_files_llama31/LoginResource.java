/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginResource {
    public void login(HttpServletRequest httpServletRequest, String string) {
        HttpSession httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("username", (Object)string);
    }

    public static void main(String[] stringArray) {
    }
}
