import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/uploadServlet")
public class FileUploadServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "uploads";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Process only if it's multipart content
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        String name = new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }

                // Redirect to message page
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "There was an error: " + ex.getMessage());
            }          
        } else {
            request.setAttribute("message", "Sorry, this Servlet only handles file upload requests");
        }
        
        request.getRequestDispatcher("/message.jsp").forward(request, response);    
    }

    public static void main(String[] args) {
    }
}