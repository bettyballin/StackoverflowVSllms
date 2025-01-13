/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SecureSessionManager {
    public void processRequest(HttpServletRequest httpServletRequest, HttpSession httpSession) {
        String string = httpServletRequest.getParameter("sensitiveData");
        httpSession.setAttribute("sensitiveData", (Object)string);
        String string2 = (String)httpSession.getAttribute("sensitiveData");
    }

    public static void main(String[] stringArray) {
    }
}
