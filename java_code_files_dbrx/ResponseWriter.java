import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class ResponseWriter {
    public void writeResponse(HttpServletResponse response, byte[] result) throws IOException {
        response.getOutputStream().write(result);
        response.flushBuffer(); // forces flush of any buffered content to underlying HttpServletResponse implementation
    }
}