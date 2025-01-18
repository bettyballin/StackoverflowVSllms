import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface WebFilter {
    String value();
}

class ServletException extends Exception {
    public ServletException() {
        super();
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServletException(Throwable cause) {
        super(cause);
    }
}

interface Filter {
    void init(FilterConfig filterConfig) throws ServletException;

    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException;

    void destroy();
}

interface FilterChain {
    void doFilter(ServletRequest request, ServletResponse response) throws java.io.IOException, ServletException;
}

interface FilterConfig {
    // Configuration methods here...
}

interface ServletRequest {
    // Request methods here...
}

interface ServletResponse {
    // Response methods here...
}

@WebFilter("/*")
public class ResponseBufferFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code here...
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws java.io.IOException, ServletException {
        // Filtering code here...
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code here...
    }
}