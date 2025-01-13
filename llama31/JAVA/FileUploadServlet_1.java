import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet_1_1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(req);

            // Process the uploaded file
            for (FileItem item : items) {
                if (!item.isFormField()) {
                    // Process the uploaded file here
                    System.out.println("File uploaded: " + item.getName());
                }
            }

            // Send a response back to the client
            resp.setContentType("text/html");
            resp.getWriter().print("<script>alert('File uploaded successfully!');</script>");
        } catch (Exception e) {
            // Handle errors here
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error uploading file");
        }
    }

    public static void main(String[] args) {
    }
}