import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.ByteArrayView;

public class PdfController_1_1 {

    @GetMapping("/pdf")
    public ModelAndView showPdf() {
        // fetch PDF via webservice
        byte[] pdfBytes = fetchPdfViaWebService();
        
        // return a ModelAndView with a byte array view
        return new ModelAndView(new ByteArrayView(pdfBytes, "application/pdf"));
    }

    // You need to implement this method or import the correct class
    private byte[] fetchPdfViaWebService() {
        // Your implementation here
        return new byte[0];
    }

    public static void main(String[] args) {
    }
}