import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploaderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                // Create a factory for disk-based file items
                FileItemFactory factory = new DiskFileItemFactory();

                // Set the repository path
                ServletContext servletContext = getServletContext();
                File repositoryPath = new File(servletContext.getRealPath("/temp"));
                factory.setRepository(repositoryPath);

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);

                // Parse the request
                List items = upload.parseRequest(request);

                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    // Check if the item is a file
                    if (!item.isFormField()) {
                        // Get the file name
                        String fileName = item.getName();

                        // Write the file to disk
                        File uploadedFile = new File(servletContext.getRealPath("/applets"), fileName);
                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException ex) {
                Logger.getLogger(FileUploaderServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FileUploaderServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // ... rest of the code ...
    }

    public static void main(String[] args) {
    }
}