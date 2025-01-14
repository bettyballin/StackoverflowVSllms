import java.lang.String;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/foo/*")
public class URLRewriteFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String pathInfo = httpRequest.getPathInfo();
        
        if (pathInfo != null && pathInfo.startsWith("/bar.do")) {
            // Modify the request URI to point to old context
            RequestDispatcher dispatcher = request.getRequestDispatcher("/someproduct" + pathInfo);
            dispatcher.forward(request, response);
        } else {
            // If not a match, continue with original request
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

	public static void main(String[] args) {
	}
}