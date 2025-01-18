import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ByteArrayOutputStream;
import javax.servlet.WriteListener;

public class LoggingFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code (if needed)
    }

    public void destroy() {
        // Cleanup code (if needed)
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        MyCapturingWriter capturer = new MyCapturingWriter(((HttpServletResponse) response).getCharacterEncoding());
        chain.doFilter(request, new HttpServletResponseWrapper((HttpServletResponse) response) {
            @Override
            public ServletOutputStream getOutputStream() throws IOException {
                return capturer;
            }

            @Override
            public PrintWriter getWriter() throws IOException {
                return capturer.getWriter();
            }
        });
    }

    public static void main(String[] args) {
        // Main method (if needed)
    }
}

class MyCapturingWriter extends ServletOutputStream {

    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintWriter printWriter;
    private String characterEncoding;

    public MyCapturingWriter(String characterEncoding) {
        this.characterEncoding = characterEncoding;
        this.printWriter = new PrintWriter(baos);
    }

    @Override
    public void write(int b) throws IOException {
        baos.write(b);
    }

    @Override
    public boolean isReady() {
        // Assuming the stream is always ready
        return true;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {
        // WriteListener not implemented for simplicity
    }

    public PrintWriter getWriter() {
        return printWriter;
    }

    public String getCapturedData() throws IOException {
        printWriter.flush();
        return baos.toString(characterEncoding);
    }
}