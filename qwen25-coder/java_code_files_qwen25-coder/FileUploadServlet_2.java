import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig // To support file upload
public class FileUploadServlet_2 extends HttpServlet {
    private static final long serialVersionUID = 1L;
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
        if (filePart != null) {
            String fileName = filePart.getSubmittedFileName();
                
            // For example purposes, saving the file to the server's temp directory
            InputStream fileContent = filePart.getInputStream();
            String uploadPath = System.getProperty("java.io.tmpdir") + File.separator + fileName;
            Files.copy(fileContent, Paths.get(uploadPath), StandardCopyOption.REPLACE_EXISTING);
                
            response.getWriter().write(fileName); // Echo back the filename
                
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("File upload failed");
        }
    }
    
    public static void main(String[] args) {
    }
}