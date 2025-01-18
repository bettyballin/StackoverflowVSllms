import java.lang.String;
import java.io.ByteArrayOutputStream;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PdfStampGenerator {
    ByteArrayOutputStream baos;
    PdfReader reader;
    PdfStamper stamper;

    public PdfStampGenerator() throws Exception {
        baos = new ByteArrayOutputStream();
        reader = null;
        stamper = new PdfStamper(reader, baos);
    }

    public static void main(String[] args) {
    }
}