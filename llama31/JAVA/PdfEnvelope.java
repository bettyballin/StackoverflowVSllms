import java.lang.String;
import java.lang.Set;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class generates a PDF document sized for an envelope.
 */
public class PdfEnvelope {
    public static void main(String[] args) throws DocumentException, IOException {
        // Create a new document
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(new File("envelope.pdf")));
        document.open();

        // Set the envelope size (e.g. DL Envelope: 220mm x 110mm)
        document.setPageSize(new com.itextpdf.text.Rectangle(220f, 110f));

        // Add your envelope content here

        // Close the document
        document.close();
    }
}