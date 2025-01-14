import java.lang.String;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String templateLocation = Config.getInstance().getString("Site.templateDirectory");

        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=output.zip");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(templateLocation));
             BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream())) {

            int len;
            byte[] buffer = new byte[1024];

            while ((len = bis.read(buffer)) > 0) {
                bos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to download file");
        }
    }

    public static void main(String[] args) {
    }
}

class Config {
    private static Config instance = new Config();

    public static Config getInstance() {
        return instance;
    }

    public String getString(String key) {
        return "template.zip";
    }
}