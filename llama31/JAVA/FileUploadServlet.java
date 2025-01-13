import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

// Using Java Servlet API
// Set the following in your web.xml
// <multipart-config>
//   <max-file-size>10485760</max-file-size> // 10MB
//   <max-request-size>20971520</max-request-size> // 20MB
//   <file-size-threshold>5242880</file-size-threshold> // 5MB
// </multipart-config>

// In your Servlet
@WebServlet(name = "FileUploadServlet", urlPatterns = "/upload")
@javax.servlet.annotation.MultipartConfig(maxFileSize = 10485760) // 10MB
public class FileUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part filePart = req.getPart("file"); // get the file part
        try (InputStream fileInputStream = filePart.getInputStream()) {
            // Process the file stream
        }
    }

    public static void main(String[] args) {
    }
}