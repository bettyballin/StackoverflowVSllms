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
 *  javax.servlet.annotation.WebFilter
 *  javax.servlet.http.HttpServletRequest
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(value={"/*"})
public class AuthenticationFilter
implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (this.isResourceFile(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (this.authenticate(servletRequest)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {
    }

    private boolean isResourceFile(ServletRequest servletRequest) {
        String string = ((HttpServletRequest)servletRequest).getRequestURI();
        return string.startsWith("/static/") && (string.endsWith(".css") || string.endsWith(".js"));
    }

    private boolean authenticate(ServletRequest servletRequest) {
        return true;
    }

    public static void main(String[] stringArray) {
    }
}
