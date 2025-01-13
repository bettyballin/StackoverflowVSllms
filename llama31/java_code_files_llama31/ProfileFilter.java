/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.servlet.Filter
 *  javax.servlet.FilterChain
 *  javax.servlet.ServletException
 *  javax.servlet.ServletRequest
 *  javax.servlet.ServletResponse
 *  javax.servlet.http.HttpServletRequest
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ProfileFilter
implements Filter {
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String string = httpServletRequest.getRequestURI();
        String[] stringArray = string.split("/");
        String string2 = null;
        if (stringArray.length > 2) {
            string2 = stringArray[2];
        }
        httpServletRequest.setAttribute("username", (Object)string2);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public static void main(String[] stringArray) {
    }
}
