import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class WhitespaceFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Initialization code, if needed.
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);

        String rspOut = wrapper.toString().replaceAll("\\s+", " ");
        response.getWriter().write(rspOut);
    }

    public void destroy() {
    }

    public static void main(String[] args) {
    }
}

class CharResponseWrapper extends HttpServletResponseWrapper {

    private StringWriter sw = new StringWriter();
    private PrintWriter writer = new PrintWriter(sw);

    public CharResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return writer;
    }

    @Override
    public String toString() {
        return sw.toString();
    }
}