// Example using iText
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.io.IOException;
import java.io.FileNotFoundException;

public class Main_744 {
    public static void main(String[] args) throws com.itextpdf.io.IOException {
        String outputPdfPath = "output.pdf"; // specify the output PDF path

        PdfWriter writer = new PdfWriter(outputPdfPath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Add content to the PDF
        document.add(new Paragraph("Hello World!"));

        document.close();
    }
}