import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class DownloadFile {
    public void download(HttpServletResponse response, int fileSize) throws Exception {
        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename=\"yourfile.pdf\"");
        response.setHeader("Content-Length", String.valueOf(fileSize)); 
        OutputStream o = response.getOutputStream();
        // then write to the output stream
    }
}