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

public class URLMaskingFilter
implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String string = httpServletRequest.getRequestURI();
        String string2 = httpServletRequest.getQueryString();
        if (string2 != null && string2.contains("id") && string2.contains("name")) {
            String string3 = this.getParameterValue(string2, "id");
            String string4 = this.getParameterValue(string2, "name");
            String string5 = "/product-" + string4.replace("_", "-");
            httpServletResponse.sendRedirect(string5);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private String getParameterValue(String string, String string2) {
        String[] stringArray;
        for (String string3 : stringArray = string.split("&")) {
            if (!string3.startsWith(string2 + "=")) continue;
            return string3.substring(string3.indexOf("=") + 1);
        }
        return null;
    }

    public void destroy() {
    }

    public static void main(String[] stringArray) {
    }
}
