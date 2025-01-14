import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CustomResponseWrapper extends HttpServletResponseWrapper {
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintWriter pw;

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (pw == null) {
            pw = new PrintWriter(new OutputStreamWriter(baos, getCharacterEncoding()), true);
        }
        return pw;
    }

    @Override
    public void flushBuffer() throws IOException {
        // Method body can be implemented as needed
    }

    @Override
    public void resetBuffer() {
        baos.reset();
    }

    @Override
    public int getBufferSize() {
        return baos.size();
    }

    public byte[] toByteArray() {
        return baos.toByteArray();
    }

    public static void main(String[] args) {
        // Main method implementation
    }
}