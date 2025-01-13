import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class HeaderFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Cache-Control", "max-age=3600, public"); // set cache control header
        chain.doFilter(request, response);
    }

    public void destroy() {
    }

	public static void main(String[] args) {
	}
}