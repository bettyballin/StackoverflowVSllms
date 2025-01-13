import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse) response);
        chain.doFilter(request, wrapper);
        // Modify the response as needed
        wrapper.getOutputStream().write("Modified output".getBytes());
    }

    public static void main(String[] args) {
    }
}

class ResponseWrapper extends HttpServletResponseWrapper {
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                // You need to implement this method
            }

            @Override
            public void write(byte[] b) throws IOException {
                // You need to implement this method
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                // You need to implement this method
            }

            @Override
            public boolean isReady() {
                // You need to implement this method
                return false;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {
                // You need to implement this method
            }
        };
    }
}