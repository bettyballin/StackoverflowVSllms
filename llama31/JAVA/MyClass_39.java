import java.lang.String;

// Import the necessary library for PDF creation
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.html2pdf.HtmlConverter;

public class MyClass_39_39 {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello, World!</h1></body></html>";

        // Create a PDF writer
        PdfWriter writer = new PdfWriter("example.pdf");

        // Create a PDF document
        PdfDocument pdfDoc = new PdfDocument(writer);

        // Create a new page
        PdfPage page = pdfDoc.addNewPage();

        // Create a new document
        Document document = new Document(pdfDoc);

        // Write HTML to the document
        document.add(new Paragraph(HtmlConverter.convertToElements(html)));

        // Close the document
        document.close();
    }
}