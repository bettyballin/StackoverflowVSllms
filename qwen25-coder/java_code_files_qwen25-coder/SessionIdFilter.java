import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class SessionIdFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Wrap the response to intercept URL rewriting
        HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpResponse) {
            @Override
            public String encodeRedirectUrl(String url) {
                return super.encodeRedirectUrl(removeJSessionID(url));
            }

            @Override
            public String encodeURL(String url) {
                return super.encodeURL(removeJSessionID(url));
            }

            private String removeJSessionID(String url) {
                if (url == null || url.indexOf(";jsessionid=") < 0) {
                    return url;
                }
                // Remove jsessionid from the URL
                return url.replaceAll(";jsessionid=[^?&#]+", "");
            }
        };

        chain.doFilter(request, wrappedResponse);
    }

    public void destroy() {}

	public static void main(String[] args) {
	}
}