import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PdfController {

    @GetMapping("/pdf")
    public void showPdf(HttpServletResponse response) throws IOException {
        // fetch PDF via webservice
        byte[] pdfBytes = fetchPdfViaWebService();
        
        // set the response headers
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=example.pdf");
        
        // write the PDF to the response output stream
        ServletOutputStream os = response.getOutputStream();
        os.write(pdfBytes);
        os.flush();
        os.close();
    }

    // You need to implement this method to fetch the PDF via web service
    private byte[] fetchPdfViaWebService() {
        // TO DO: implement this method
        return new byte[0];
    }

    public static void main(String[] args) {
    }
}