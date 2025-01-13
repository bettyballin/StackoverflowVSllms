import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TemplateDownloader extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            String templateLocation = Config.getInstance().getString("Site.templateDirectory");

            response.setContentType("application/zip");
            response.setHeader("Content-Disposition", "attachment; filename=output.zip;");

            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            FileInputStream fis = new FileInputStream(templateLocation);

            int len;
            byte[] buf = new byte[1024];

            while ((len = fis.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }

            bos.close();
            fis.close(); // Close the FileInputStream to prevent resource leak
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // This main method is not needed for a servlet, but it's here to make the code compile
    }
}