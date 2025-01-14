import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UrlCharacterReplaceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            final HttpServletRequest httpRequest = (HttpServletRequest) request;
            String path = httpRequest.getRequestURI();
            // Replace spaces with hyphens or other desired characters
            String newPath = path.replace(' ', '-');
            
            // Create a wrapper to modify the URI for downstream processing
            chain.doFilter(new HttpServletRequestWrapper(httpRequest) {
                @Override
                public String getRequestURI() {
                    return newPath;
                }
            }, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}

    public static void main(String[] args) {
    }
}