import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Assuming you have a String to send
        String message = "Hello from the JSP filter";

        // Store it in ServletContext
        ServletContext context = request.getServletContext();
        context.setAttribute("sharedMessage", message);

        // Continue with the next item in the filter chain
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    public static void main(String[] args) {
    }
}