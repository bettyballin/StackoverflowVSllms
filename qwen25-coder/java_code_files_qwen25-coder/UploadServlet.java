import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(request);
                
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        
                        // Save the file somewhere
                        String filePath = "/path/to/save/" + fileName;
                        File uploadedFile = new File(filePath);
                        item.write(uploadedFile);

                        response.getWriter().write(fileName);  // Return filename for success message
                    }
                }

            } catch (Exception e) {
                throw new ServletException("File upload error");
            }
        }
    }

    public static void main(String[] args) {
    }
}