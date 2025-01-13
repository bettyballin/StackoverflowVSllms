import java.lang.String;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class URLLengthValidatorFilter implements Filter {
    private int maxLength = 200; // adjust this value based on your application's requirements

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String url = ((HttpServletRequest) request).getRequestURI();
        if (url.length() > maxLength) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_BAD_REQUEST, "URL too long");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}

    public static void main(String[] args) {}
}