import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfTemplateExample {
    public static void main(String[] args) throws IOException, DocumentException {
        // Load the PDF template containing the vector image
        PdfReader templateReader = new PdfReader("template.pdf");
        PdfTemplate template = templateReader.getPageN(1);

        // Create a new PDF document
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        // Add the PDF template to the document
        writer.addTemplate(template, 0, 0);

        // Close the PDF document
        document.close();

        // Close the template reader
        templateReader.close();
    }
}