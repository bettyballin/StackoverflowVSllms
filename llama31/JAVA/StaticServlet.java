import java.lang.String;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class StaticServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String path = req.getServletPath() + req.getPathInfo();
        File file = new File(getServletContext().getRealPath(path));

        if (file.exists() && file.isFile()) {
            long lastModified = file.lastModified();
            String ifModifiedSince = req.getHeader("If-Modified-Since");
            if (ifModifiedSince != null) {
                Date ifModifiedSinceDate = new Date(ifModifiedSince);
                if (lastModified <= ifModifiedSinceDate.getTime()) {
                    resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                    return;
                }
            }

            resp.setContentType(getContentType(file));
            resp.setLastModified(lastModified);

            OutputStream out = resp.getOutputStream();
            FileInputStream in = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
            out.close();
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private String getContentType(File file) {
        String fileName = file.getName();
        int extensionIndex = fileName.lastIndexOf('.');
        if (extensionIndex > 0) {
            String extension = fileName.substring(extensionIndex + 1);
            if ("css".equals(extension)) {
                return "text/css";
            } else if ("js".equals(extension)) {
                return "application/javascript";
            } else if ("jpg".equals(extension) || "jpeg".equals(extension)) {
                return "image/jpeg";
            } else if ("png".equals(extension)) {
                return "image/png";
            } else if ("gif".equals(extension)) {
                return "image/gif";
            }
        }
        return "application/octet-stream";
    }

    public static void main(String[] args) {
    }
}