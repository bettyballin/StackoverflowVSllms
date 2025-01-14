import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain next) throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            ((HttpServletRequest)request).setCharacterEncoding("UTF-8");
        }
        response.setCharacterEncoding("UTF-8");

        next.doFilter(request, response);
    }

	public static void main(String[] args) {
	}
}