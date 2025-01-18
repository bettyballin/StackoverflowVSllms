import java.io.File;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import java.util.List;
import java.util.Iterator;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadHandler extends HttpServlet {
    // Fix the typo in setRepository

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

        ServletContext servletContext = this.getServletConfig().getServletContext();
        String uploadFolder = "temp"; // Or whatever path you choose to save the files initially
        String realUploadPath = servletContext.getRealPath("") + File.separator + uploadFolder;
        File repositoryPath = new File(realUploadPath);

        diskFileItemFactory.setRepository(repositoryPath);
        servletContext.setAttribute("repositoryPath", repositoryPath); // If needed for later use in another class

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);

        try {
            List<FileItem> formItems = upload.parseRequest(request);
            Iterator<FileItem> iter = formItems.iterator();

            // ... other existing logic here ...
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField() && item.getName().length() > 0){
                    String fileName = new File(item.getName()).getName(); // Get only the filename, not the entire path including directories
                    String filePath = "applets" + File.separator + fileName; // Choose final destination of file here: "applets"+File.separator+fileName
                    File storeFile = new File(servletContext.getRealPath("")  + File.separator + filePath);

                    // If the directory doesn't exist, create it
                    if (!storeFile.getParentFile().exists()) {
                        storeFile.getParentFile().mkdirs();
                    }
                    item.write(storeFile); // Save to final location
                }
            }
        } catch (Exception ex) {
            // Handle exception
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}