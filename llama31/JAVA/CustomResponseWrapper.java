import java.lang.String;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter buffer;
    private PrintWriter writer;

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
        buffer = new CharArrayWriter();
        writer = new PrintWriter(buffer);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return writer;
    }

    @Override
    public void flushBuffer() throws IOException {
        // Don't flush the buffer yet, we want to control the output
    }

    public void flush() throws IOException {
        // Now we can flush the buffer and write the data to the JspWriter
        HttpServletResponse response = (HttpServletResponse) getResponse();
        response.getWriter().write(buffer.toString());
        buffer.reset();
    }

	public static void main(String[] args) {
	}
}