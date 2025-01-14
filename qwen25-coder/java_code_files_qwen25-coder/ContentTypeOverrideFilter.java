import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ContentTypeOverrideFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code here, if necessary
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        // Wrap the original response object with a custom HttpServletResponseWrapper
        ContentTypeOverrideResponse wrapResponse = new ContentTypeOverrideResponse((HttpServletResponse) response);
        
        // Proceed with the rest of the filter chain using the wrapped response
        chain.doFilter(request, wrapResponse);
    }

    @Override
    public void destroy() {
        // Cleanup code here, if necessary
    }
    
    private static class ContentTypeOverrideResponse extends HttpServletResponseWrapper {
        /**
         * Constructor that calls super constructor.
         * @param response an instance of HttpServletResponse to be wrapped
         */
        public ContentTypeOverrideResponse(HttpServletResponse response) { 
            super(response);
        }

        @Override
        public void setContentType(String type) {
            // Set the desired content type here
            String override = "application/xhtml+xml";
            if (!type.equals(override)) {
                super.setContentType(override);
            }
        }
    }

    public static void main(String[] args) {
    }
}