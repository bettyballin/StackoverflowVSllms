import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class ErrorHandlingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        CustomResponseWrapper customResponse = new CustomResponseWrapper((HttpServletResponse) response);
        
        try {
            // Proceed with the filter chain (servlet request processing)
            chain.doFilter(request, customResponse);

            int statusCode = customResponse.getStatusCode();
            if (statusCode != HttpServletResponse.SC_OK) {
                ((HttpServletResponse) response).sendError(statusCode);
            }
        } catch (Exception e) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    @Override
    public void destroy() {}

    // Custom Response Wrapper to capture status code and headers
    private static class CustomResponseWrapper extends HttpServletResponseWrapper {
        private int statusCode = HttpServletResponse.SC_OK;

        protected CustomResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public void sendError(int sc, String msg) throws IOException {
            super.sendError(sc, msg); // Important: delegate to original response
            setStatusCode(sc);
        }

        @Override
        public void setStatus(int sc) {
            super.setStatus(sc);
            setStatusCode(sc);
        }

        private void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    public static void main(String[] args) {
    }
}