import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZipDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String zipLocation = "C:\\zipfile.zip";
        response.setContentType("application/zip");
        response.setHeader("Content-Disposition", "attachment; filename=zipfile.zip");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(zipLocation));
             ServletOutputStream sos = response.getOutputStream();
             BufferedOutputStream bos = new BufferedOutputStream(sos)) {

            int len;
            byte[] buf = new byte[1024];

            while ((len = bis.read(buf)) > 0) {
                bos.write(buf, 0, len);
            }
        }
    }
}