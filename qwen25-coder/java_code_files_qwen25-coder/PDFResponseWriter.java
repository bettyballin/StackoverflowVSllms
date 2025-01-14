import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

public class PDFResponseWriter {
    // Assuming 'fileSize' is the variable containing the size of the PDF in bytes
    private HttpServletResponse response;
    private int fileSize;

    {
        response.setContentType("application/pdf");
        response.setContentLength(fileSize);
        OutputStream o = response.getOutputStream();
    }

    public static void main(String[] args) {
    }
}