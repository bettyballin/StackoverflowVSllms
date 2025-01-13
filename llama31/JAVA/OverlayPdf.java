import java.io.FileOutputStream;
import java.lang.String;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class OverlayPdf {
  public static void main(String[] args) throws Exception {
    PdfReader reader1 = new PdfReader("fileA.pdf");
    PdfReader reader2 = new PdfReader("fileB.pdf");
    PdfStamper stamper = new PdfStamper(reader1, new FileOutputStream("output.pdf"));
    stamper.overlay(reader2);
    stamper.close();
  }
}