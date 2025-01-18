import java.lang.String;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;

public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        for (Part part : request.getParts()) {
            /* Write file to a permanent location*/
            String fileName = "file_" + new Date().getTime()+"."+com.google.common.io.Files.getFileExtension(part.getSubmittedFileName());
            String path = "C:/" + fileName; //You choose your application directory here
            try (OutputStream out = Files.newOutputStream(Paths.get(path))) {
                InputStream in = part.getInputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            //Then you decide what to do with file e.g send path or delete temp file.
        }
    }

    public static void main(String[] args) {
    }
}