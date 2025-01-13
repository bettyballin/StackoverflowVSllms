import java.lang.String;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletRequest;

public class FileUploadChecker {
    // Check that we have a file upload request
    public static void main(String[] args) {
        HttpServletRequest request = null; // You need to get the request object from somewhere
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    }
}