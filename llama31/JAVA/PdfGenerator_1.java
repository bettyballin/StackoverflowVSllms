import com.lowagie.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.FileOutputStream;
import java.io.IOException;

public class PdfGenerator_1_1 {
    public static void main(String[] args) {
        String htmlContent = "<html><body>Hello, World!</body></html>"; // example html content
        String outputFile = "output.pdf"; // output file name

        try {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            renderer.createPDF(outputStream);
            outputStream.close();
        } catch (DocumentException | IOException e) {
            System.err.println("Error generating PDF: " + e.getMessage());
        }
    }
}