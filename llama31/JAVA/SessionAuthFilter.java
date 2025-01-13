import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SessionAuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        // Check if user is authenticated
        if (session.getAttribute("authenticated") == null) {
            // Redirect to login page
            httpRequest.sendRedirect("/webserverpath/main/login.jsp");
            return;
        }

        // User is authenticated, proceed with the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    public static void main(String[] args) {}
}