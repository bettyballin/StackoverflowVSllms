import java.lang.String;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class WhitespaceTrimmerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        var respWrapper = new WhitespaceRemovingResponseWrapper((HttpServletResponse)response);
        chain.doFilter(request, respWrapper);
        respWrapper.flushBuffer(); // don't forget to flush the buffer!
    }

    @Override
    public void destroy() {}

    public static void main(String[] args) {
    }
}