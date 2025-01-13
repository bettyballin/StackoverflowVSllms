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

public class AuthFilter
implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        if (httpServletRequest.getRequestURI().startsWith("/static/")) {
            String string = httpServletRequest.getHeader("Authorization");
            if (string == null || !string.startsWith("Basic ")) {
                httpServletResponse.setStatus(401);
                httpServletResponse.setHeader("WWW-Authenticate", "Basic realm=\"My Realm\"");
                return;
            }
            String[] stringArray = string.substring(6).split(":");
            String string2 = stringArray[0];
            String string3 = stringArray[1];
            if (!string2.equals("admin") || !string3.equals("password")) {
                httpServletResponse.setStatus(401);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
    }

    public static void main(String[] stringArray) {
    }
}
