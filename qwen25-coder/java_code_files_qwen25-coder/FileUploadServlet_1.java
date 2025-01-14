import java.lang.String;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
    maxFileSize = 1024 * 1024 * 10,      // 10MB
    maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class FileUploadServlet_1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream fileContent = filePart.getInputStream();

        try (OutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/uploadedFiles/" + fileName)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = fileContent.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
        }

        response.getWriter().println("File " + fileName + " has uploaded successfully!");
    }

    public static void main(String[] args) {
    }
}