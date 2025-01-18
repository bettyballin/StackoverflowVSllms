import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FileDownloadServlet_1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        File file = new File("/path/to/yourfile");
        String mimeType = "application/pdf"; // change it as required according to the type of file (e.g., .txt, .xml)
        response.setContentType(mimeType);
        String yourFileName = "yourfilename.pdf"; // specify your file name here
        response.addHeader("Content-Disposition", "attachment; filename=" + yourFileName);
        OutputStream fos = response.getOutputStream();
        FileInputStream fis = new FileInputStream(file);
        int c;
        while ((c = fis.read()) != -1) {
            fos.write((byte) c);
        }
        fos.flush();
        fis.close();
    }
}