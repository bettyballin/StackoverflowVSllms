import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StaticFileHeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Set custom headers for static files
        String path = ((HttpServletRequest)request).getRequestURI();
        if (path.endsWith(".doc") || path.endsWith(".docx")) {  // Adjust as needed for other file types
            httpResponse.setHeader("Cache-Control", "max-age=3600, public");
            httpResponse.setHeader("Pragma", "public"); // For HTTP/1.0 clients
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
    }
}