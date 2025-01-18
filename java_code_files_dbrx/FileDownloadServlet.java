import java.lang.String;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String zipLocation = "/path/to/zipfile.zip"; // replace with proper path or inject it as a dependency.
        File file = new File(zipLocation);

        BufferedInputStream bis = null;
        int b;
        resp.setContentType("application/zip");
        try {
            resp.setHeader("Content-Disposition", "attachment; filename=output.zip"); //change output to zip or another name if required.
            OutputStream outputStream = resp.getOutputStream();   // get output stream from the response object
            bis = new BufferedInputStream(new FileInputStream(file));
            while ((b = bis.read()) > -1) {        // Read and write one byte at a time until the end of file is reached (-1).
                outputStream.write(b);
            }
        } catch (Exception e){
            e.printStackTrace();// log the exception for easier debugging, do not print stack trace in production code
        } finally {
            if (bis != null) bis.close(); // Ensuring resource closure
        }
    }
    public static void main(String[] args) {
    }
}