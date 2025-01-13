import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (isResourceFile(request)) {
            chain.doFilter(request, response); // pass through to next filter or servlet
        } else {
            // perform authentication logic here
            if (authenticate(request)) {
                chain.doFilter(request, response);
            } else {
                // handle authentication failure
            }
        }
    }

    @Override
    public void destroy() {
    }

    private boolean isResourceFile(ServletRequest request) {
        String url = ((HttpServletRequest) request).getRequestURI();
        // check if URL points to a resource file (e.g., CSS, JS, etc.)
        return url.startsWith("/static/") && (url.endsWith(".css") || url.endsWith(".js"));
    }

    private boolean authenticate(ServletRequest request) {
        // implement your authentication logic here
        return true; // placeholder
    }

    public static void main(String[] args) {
    }
}