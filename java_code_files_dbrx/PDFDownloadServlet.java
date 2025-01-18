import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PDFDownloadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long contentLength = 0L; // obtain the file size in bytes

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment;filename=yourfile.pdf");
        response.setHeader("Content-Length", String.valueOf(contentLength));

        OutputStream outputStream = response.getOutputStream();
        // write your PDF content to the OutputStream and close it after writing.
    }

}