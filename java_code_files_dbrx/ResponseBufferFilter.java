import java.lang.String;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class ResponseBufferFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if necessary
    }

    @Override
    public void destroy() {
        // Cleanup code, if necessary
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        MyHttpServletResponse myResponse = new MyHttpServletResponse((HttpServletResponse) resp);
        chain.doFilter(req, myResponse);
        // You can manipulate headers and the response before sending back to client if needed after chain processing:
        String content = myResponse.getContent();
        // Manipulating the content as per your requirements...
    }
}

class MyHttpServletResponse extends HttpServletResponseWrapper {
    private CharArrayWriter output;

    public MyHttpServletResponse(HttpServletResponse response) {
        super(response);
        this.output = new CharArrayWriter();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                output.write(b);
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {
                // No-op
            }

            @Override
            public boolean isReady() {
                return true;
            }
        };
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(output);
    }

    public String getContent() {
        return output.toString();
    }

    // You can override these functions to manipulate headers:
    /*
    @Override
    public void sendError(int sc, String msg) throws IOException {
        super.sendError(sc, msg);
    }

    @Override
    public void setContentLength(int len) {
        // super.setContentLength(len);
    }
    */

    // Other overridden functions may be required depending on your use case: redirect, headers etc.

    public static void main(String[] args) {
    }
}