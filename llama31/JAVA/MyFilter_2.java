import javax.servlet.*;
import javax.servlet.http.HttpServletResponse; // Added necessary import
import java.io.IOException;

public class MyFilter_2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Example condition added for compilation purposes
        if (request.getParameter("example") != null) {
            ((HttpServletResponse) response).setStatus(500);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}

    // Added a main method for direct execution demonstration
    // This is just to make the class "runnable" but doesn't actually test the filter
    public static void main(String[] args) {
        System.out.println("This class is a servlet filter and cannot be executed directly.");
    }
}