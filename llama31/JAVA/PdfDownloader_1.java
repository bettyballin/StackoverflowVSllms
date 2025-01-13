import java.io.FileInputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

public class PdfDownloader_1_1 {
    public void downloadPdf(HttpServletResponse response) throws Exception {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=myfile.pdf");
        FileInputStream in = new FileInputStream("myfile.pdf");
        OutputStream out = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        PdfDownloader_1 downloader = new PdfDownloader_1();
        // You would need to get an HttpServletResponse object from a servlet container
        // For the purpose of this example, we will create a mock HttpServletResponse
        HttpServletResponse response = new MockHttpServletResponse();
        downloader.downloadPdf(response);
    }
}

// Mock HttpServletResponse for demonstration purposes only
class MockHttpServletResponse implements HttpServletResponse {
    public void setContentType(String type) {
        System.out.println("Content-Type: " + type);
    }

    public void setHeader(String name, String value) {
        System.out.println(name + ": " + value);
    }

    public OutputStream getOutputStream() {
        return System.out;
    }
}