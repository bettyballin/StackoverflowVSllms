import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class Main_786_786 {
    public static void main(String[] args) throws IOException {
        PdfWriter writer = new PdfWriter("path_to_your_file.pdf");
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document doc = new Document(pdfDoc);

        // The following will include a paragraph with a Unicode character
        doc.add(new Paragraph(""));

        doc.close();
    }
}