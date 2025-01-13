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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomStaticResourceFilter
implements Filter {
    private static final String RESOURCE_PATH = "/META-INF/resources/";

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        URL uRL;
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String string = httpServletRequest.getRequestURI();
        if (string.startsWith(RESOURCE_PATH) && (uRL = this.getClass().getClassLoader().getResource(string)) != null) {
            httpServletResponse.setContentType("application/javascript");
            httpServletResponse.getWriter().write(this.readResource(uRL));
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String readResource(URL uRL) throws IOException {
        String string;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRL.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        while ((string = bufferedReader.readLine()) != null) {
            stringBuilder.append(string).append("\n");
        }
        bufferedReader.close();
        return stringBuilder.toString();
    }

    public static void main(String[] stringArray) {
    }
}
