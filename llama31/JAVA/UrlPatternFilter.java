import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.regex.Pattern;

public class UrlPatternFilter implements Filter {
    private Pattern pattern;

    @Override
    public void init(FilterConfig filterConfig) {
        pattern = Pattern.compile("/([a-zA-Z]+)_.*");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String url = httpRequest.getRequestURI();
        if (pattern.matcher(url).matches()) {
            // Forward to the desired servlet
            httpRequest.getRequestDispatcher("/MyServlet").forward(request, response);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}

	public static void main(String[] args) {
	}
}