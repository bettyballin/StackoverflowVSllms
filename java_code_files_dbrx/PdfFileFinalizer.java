import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfReader;
import java.io.OutputStream;
import java.io.IOException;
import com.itextpdf.text.DocumentException;

public class PdfFileFinalizer {
    PdfReader reader = null;
    OutputStream os = null;
    PdfStamper stamper;

    {
        try {
            stamper = new PdfStamper(reader, os); // os is output stream where you will write your final pdf
            stamper.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}