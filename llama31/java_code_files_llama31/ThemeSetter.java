/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ThemeSetter {
    public void setTheme(HttpSession httpSession, HttpServletRequest httpServletRequest) {
        httpSession.setAttribute("theme", (Object)httpServletRequest.getParameter("theme"));
    }

    public static void main(String[] stringArray) {
    }
}
