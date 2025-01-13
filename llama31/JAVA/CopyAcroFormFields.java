import java.io.FileOutputStream;
import java.lang.String;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class CopyAcroFormFields {
    public static void main(String[] args) throws Exception {
        PdfReader reader = new PdfReader("source.pdf");
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("destination.pdf"));
        document.open();
        PdfCopy copy = new PdfCopy(document, reader);
        
        copy.addDocument(reader);
        copy.setFormFlattening(false);
        copy.setMergeFields(true);
        
        document.close();
        reader.close();
        writer.close();
    }
}