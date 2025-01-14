import java.lang.String;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.PrintWriter;

public class CaptureResponseWrapper extends HttpServletResponseWrapper {
    private CharArrayWriter charArrayWriter = new CharArrayWriter();
    private PrintWriter printWriter;

    public CaptureResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() {
        if (printWriter == null) {
            printWriter = new PrintWriter(charArrayWriter);
        }
        return printWriter;
    }

    @Override
    public String toString() {
        return charArrayWriter.toString();
    }

    public static void main(String[] args) {
    }
}