import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionExpirationFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
            // Check if session attribute exists. If it is null, the user's session has expired.
            ((HttpServletResponse) response).sendRedirect("/login"); // Redirect to login page when session expires
        } else {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    public void destroy() {
        // Cleanup code, if needed
    }

    public static void main(String[] args) {
    }
}