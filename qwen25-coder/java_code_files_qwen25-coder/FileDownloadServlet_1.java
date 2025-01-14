import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/download")
public class FileDownloadServlet_1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "file.zip";
        ServletContext cntxt = getServletContext();
        
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        InputStream inStream = null;
        OutputStream outStream = null;

        try {
            inStream = cntxt.getResourceAsStream("/WEB-INF/classes/" + fileName);
            if (inStream == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

        } finally {
            if (inStream != null) {
                inStream.close();
            }
            if (outStream != null) {
                outStream.close();
            }
        }
    }

    public static void main(String[] args) {
    }
}