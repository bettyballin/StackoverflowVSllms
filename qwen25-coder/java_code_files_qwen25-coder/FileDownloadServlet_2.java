import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet_2 extends HttpServlet {
    // Example Java Servlet code snippet
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] fileData = new byte[0]; // fileData is the byte array of the document
        String fileName = "example.txt"; // the file name

        response.setContentType("application/octet-stream"); // or specific MIME type
        response.setContentLength(fileData.length);
        String headerValue = String.format("attachment; filename=\"%s\"", fileName);
        response.setHeader("Content-Disposition", headerValue);

        OutputStream outStream = response.getOutputStream();
        outStream.write(fileData); // fileData is the byte array of the document
        outStream.flush();
        outStream.close();
    }

    public static void main(String[] args) {
    }
}