import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class Main_130 {
    public static void main(String[] args) {
        try {
            // Create a new Document instance
            Document doc = new Document();

            // Create a PDF writer
            PdfWriter.getInstance(doc, new FileOutputStream("output.pdf"));

            // Open the document for writing
            doc.open();

            // Close the document
            doc.close();
        } catch (FileNotFoundException | DocumentException e) {
            System.err.println(e.getMessage());
        }
    }
}