import java.lang.String;
import java.io.IOException;

interface ServletRequest {
    // Empty interface; methods can be added if necessary
}

interface ServletResponse {
    // Empty interface
}

interface FilterChain {
    void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException;
}

class ServletException extends Exception {
    public ServletException() {}
    public ServletException(String message) { super(message); }
    public ServletException(String message, Throwable rootCause) { super(message, rootCause); }
    public ServletException(Throwable rootCause) { super(rootCause); }
}

interface HttpSession {
    void setAttribute(String name, Object value);
}

interface HttpServletRequest extends ServletRequest {
    HttpSession getSession();
}

interface HttpServletResponse extends ServletResponse {
    // Empty interface
}

interface Filter {
    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException;
}

public class CurrentUserFilter_1 implements Filter {
    // In your Spring Filter class:
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        // Assuming the logged in user is available as Principal/Authentication object or from your database using a cookie containing userId.
        String name = "John Doe";  // Replace with actual fetched value.

        if (session != null) {
            session.setAttribute("currentUser", name);
        }

        chain.doFilter(request, response);
    }

    public static void main(String[] args) {
    }
}