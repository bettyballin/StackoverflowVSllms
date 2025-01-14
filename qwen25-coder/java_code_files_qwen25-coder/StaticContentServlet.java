import java.lang.String;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/static/*")
public class StaticContentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Path contentPath = Paths.get("webapp/static"); // Define the path to your static files

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || "/".equals(pathInfo)) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        Path filePath = contentPath.resolve(pathInfo.substring(1)).normalize();
        
        // Check if the requested file is within the static directory
        if (!filePath.startsWith(contentPath)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }

        if (Files.exists(filePath) && !Files.isDirectory(filePath)) {
            long lastModified = Files.getLastModifiedTime(filePath).toMillis();
            
            // Check If-Modified-Since header to determine 304 Not Modified response
            long sinceDate = request.getDateHeader("If-Modified-Since");
            if (sinceDate > -1 && lastModified / 1000 <= sinceDate / 1000) {
                response.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
                return;
            }

            String mimeType = URLConnection.guessContentTypeFromName(filePath.getFileName().toString());
            if (mimeType != null) response.setContentType(mimeType);
            
            try (FileInputStream fileIn = new FileInputStream(filePath.toFile());
                 ServletOutputStream out = response.getOutputStream()) {
                
                // Implement gzip encoding here if needed
                
                byte[] buffer = new byte[4096];
                int count;
                while ((count = fileIn.read(buffer)) > 0) {
                    out.write(buffer, 0, count);
                }
            }
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected long getLastModified(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null || "/".equals(pathInfo)) return -1;

        Path filePath = contentPath.resolve(pathInfo.substring(1)).normalize();

        try {
            return Files.getLastModifiedTime(filePath).toMillis();
        } catch (IOException e) {
            return -1;
        }
    }

	public static void main(String[] args) {
	}
}