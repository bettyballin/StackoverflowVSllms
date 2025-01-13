/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionCacheManager {
    public void setCacheItem(HttpServletRequest httpServletRequest, Object object) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("cachedItem", object);
    }

    public Object getCacheItem(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        return httpSession.getAttribute("cachedItem");
    }

    public static void main(String[] stringArray) {
    }
}
