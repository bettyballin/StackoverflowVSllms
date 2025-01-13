/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.ServletRequestEvent
 *  javax.servlet.ServletRequestListener
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionTimeoutListener
implements ServletRequestListener {
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequestEvent.getServletRequest();
        String string = httpServletRequest.getHeader("your-header-name");
        HttpSession httpSession = httpServletRequest.getSession();
        int n = 30;
        httpSession.setMaxInactiveInterval(n);
    }

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
    }

    public static void main(String[] stringArray) {
    }
}
