/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.FilterConfig
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 *  javax.servlet.http.HttpServletResponse
 *  javax.servlet.http.HttpSession
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter
implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession httpSession = httpServletRequest.getSession(false);
        if (httpSession == null) {
            httpSession = httpServletRequest.getSession(true);
        }
        if (null == httpSession.getAttribute("username")) {
            ((HttpServletResponse)servletResponse).sendRedirect("../Login.jsp");
            System.out.println("Redirected - No session");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
            System.out.println("Gone through Filter");
        }
    }

    public void destroy() {
    }

    public static void main(String[] stringArray) {
    }
}
