import javax.servlet.*;
import java.io.IOException;

public class MyFilter implements Filter {

    private ServletContext context;
    private String myStringValue = "someValue"; // Assuming some value

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Store the string in ServletContext attribute
        context.setAttribute("myAttributeName", myStringValue);
        // ...
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code if necessary
    }
}