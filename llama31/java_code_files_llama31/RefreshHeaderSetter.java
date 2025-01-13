/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RefreshHeaderSetter {
    public void setRefreshHeader(HttpServletResponse httpServletResponse, HttpSession httpSession) {
        httpServletResponse.setHeader("Refresh", httpSession.getMaxInactiveInterval() + "; URL=/nmt/extranet/asp/error.jsp");
    }
}
