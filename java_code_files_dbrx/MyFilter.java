import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if any
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponseWrapper wrappedResp = new HttpServletResponseWrapper((HttpServletResponse) res); // Wrap the original response object into another object.
        /* Modify your headers */
        chain.doFilter(req, wrappedResp);
    }

    public void destroy() {
        // Cleanup code, if any
    }

    public static void main(String[] args) {
    }
}