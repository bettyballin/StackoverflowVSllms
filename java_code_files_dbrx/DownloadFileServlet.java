import java.lang.String;
import java.io.IOException;
import java.io.BufferedOutputStream;
import javax.servlet.*;
import javax.servlet.http.*;

public class DownloadFileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the byte array of binary data from somewhere else in your application
        byte[] fileBytes = getBinaryFromSomewhere();

        response.setContentType("application/octet-stream"); // for generic binary files; you can also set appropriate content type based on your use case ex: "image/jpeg" etc..

        // This will inform the browser about how to open the file. You need to use proper MIME types.
        response.setHeader("Content-Disposition", "attachment; filename=yourFileName");

        BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream()); // for better performance create a buffer with byte[] size according to your needs. In this case, it's created at 8K (8192 bytes).
        try {
            output.write(fileBytes);
            output.flush(); // this line forces data in the buffer to be written out regardless of buffered size, so if you don't put this line before catch or finally section, it may cause empty response.
        } catch (IOException ioe) {
            // Handle exception
        } finally {
            output.close();
            request.getSession().invalidate();
        } // always close your streams after use and invalidate session on download action
    }

    private byte[] getBinaryFromSomewhere() {
        // For compilation purposes, return an empty byte array
        return new byte[0];
    }

    public static void main(String[] args) {
    }
}