import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ImageDisplayServlet extends GenericServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String imageUrl = (String)req.getParameter("imageUrl");
        if(imageUrl != null && !imageUrl.isEmpty()) {
            File fileToDownload = new File("/var/www/html/uploads/" + imageUrl);
            if(fileToDownload.exists()){
                res.setContentType(getServletContext().getMimeType(imageUrl));
                try(InputStream in = new FileInputStream(fileToDownload);
                    OutputStream out = res.getOutputStream();) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                } catch (FileNotFoundException e) {
                    res.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            }
        } else {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
        }
    }

    public static void main(String[] args) {
    }
}