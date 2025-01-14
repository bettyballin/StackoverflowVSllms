import java.lang.String;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomResponseWrapper_1 extends HttpServletResponseWrapper {

    private CharArrayWriter charArrayWriter = new CharArrayWriter();
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintWriter printWriter;

    public CustomResponseWrapper_1(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (printWriter == null) {
            printWriter = new PrintWriter(charArrayWriter);
        }
        return printWriter;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (charArrayWriter != null) {
            charArrayWriter.flush();
            byteArrayOutputStream.write(charArrayWriter.toString().getBytes(getCharacterEncoding()));
        }
        super.flushBuffer();
    }

    public String getResponseAsString() {
        return charArrayWriter == null ? "" : charArrayWriter.toString();
    }

    public byte[] getResponseAsBytes() throws IOException {
        if (printWriter != null) {
            printWriter.flush();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) {
    }
}