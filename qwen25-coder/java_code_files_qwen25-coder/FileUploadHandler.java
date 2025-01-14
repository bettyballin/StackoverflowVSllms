import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;

@WebServlet("/upload")
public class FileUploadHandler extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set the request's character encoding
        request.setCharacterEncoding("UTF-8");

        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    if (!item.isFormField()) {
                        // Process File uploads
                    } else {
                        String name = item.getFieldName();
                        String value = item.getString("UTF-8"); // Decode form field values as UTF-8
                        if ("japaneseChars".equals(name)) {
                            System.out.println("Japanese Text: " + value);
                        }
                        // Handle other fields...
                    }
                }
            } catch (FileUploadException e) {
                throw new ServletException("Cannot parse multipart request.", e);
            }
        }
    }

    public static void main(String[] args) {
    }
}