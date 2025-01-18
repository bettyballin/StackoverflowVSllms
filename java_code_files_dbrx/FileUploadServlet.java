import java.util.List;
import java.io.File;
// Import required packages
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileUploadServlet extends HttpServlet {
    // Directory where to store the uploaded files
    private String UPLOAD_DIRECTORY = "upload";

    @Override
    public void init(ServletConfig config) throws ServletException {
        // Get user defined value of upload location from init-param tag in web.xml or use default
        this.UPLOAD_DIRECTORY = (config.getInitParameter("uploadDirectory") != null) ?
            config.getInitParameter("uploadDirectory") : UPLOAD_DIRECTORY;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);

        if (isMultipartContent) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = UPLOAD_DIRECTORY + File.separator + fileName;
                        // Save the uploaded file to a specific location on the server
                        item.write(new File(filePath));

                        response.getWriter().println("Upload Successful");
                    } else {
                        throw new NullPointerException();
                    }
                }
            } catch (Throwable e) {
                System.out.println("Error during file uploading " + e);
                response.getWriter().print(e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("Request is not multipart");
        }
    }

    public static void main(String[] args) {
    }
}