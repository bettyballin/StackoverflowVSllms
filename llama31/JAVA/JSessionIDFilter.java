import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class JSessionIDFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Remove jsessionID from URL
        String requestURL = httpRequest.getRequestURL().toString();
        String jsessionID = httpRequest.getRequestedSessionId();
        if (jsessionID != null) {
            requestURL = requestURL.replaceAll(";jsessionid=" + jsessionID, "");
        }

        // Continue with the rest of the filter chain
        chain.doFilter(new HttpServletRequestWrapper(httpRequest) {
            @Override
            public String getRequestURL() {
                return requestURL;
            }
        }, response);
    }

    @Override
    public void destroy() {
    }

    public static void main(String[] args) {
    }
}