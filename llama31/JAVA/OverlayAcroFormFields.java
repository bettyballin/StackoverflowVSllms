import java.io.FileOutputStream;
import java.lang.String;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class OverlayAcroFormFields {
    public static void main(String[] args) throws Exception {
        PdfReader reader = new PdfReader("source.pdf");
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("destination.pdf"));
        
        stamper.setFormFlattening(false);
        stamper.setRotateContents(false);
        
        // add the new content
        PdfWriter writer = stamper.getWriter();
        PdfTemplate template = PdfTemplate.createTemplate(writer, 100, 100);
        stamper.getOverContent(1).addTemplate(template, 0, 0);
        
        stamper.close();
        reader.close();
    }
}