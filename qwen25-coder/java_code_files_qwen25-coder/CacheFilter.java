import java.lang.String;
import java.util.Set;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CacheFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        
        // Set cache control headers to cache images for 1 day.
        if (req.getServletPath().endsWith(".jpg") || req.getServletPath().endsWith(".png")) { 
            res.setHeader("Cache-Control", "max-age=86400, public");
            res.setDateHeader("Expires", System.currentTimeMillis() + 86400 * 1000L);
        }
        
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    public static void main(String[] args) {
    }
}