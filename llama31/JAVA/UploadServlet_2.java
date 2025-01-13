import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet_2_2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle uploaded files
        Iterator<FileItem> iter = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request).iterator();
        while (iter.hasNext()) {
            FileItem item = iter.next();
            if (!item.isFormField()) {
                // Process uploaded file
                File file = new File(getServletContext().getRealPath("/uploads"), item.getName());
                item.write(file);
            }
        }
    }

    public static void main(String[] args) {
    }
}