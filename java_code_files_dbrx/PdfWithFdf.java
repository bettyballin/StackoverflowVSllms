import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.fdf.FDFDocument;
import java.io.*;

public class PdfWithFdf {
    public static void main(String[] args) throws IOException {
        PDDocument document = null;
        try (FileInputStream fis = new FileInputStream("sample.fdf")) {
            FDFDocument fdfDoc = FDFDocument.load(fis);
            // process the FDF form data here, e.g., apply it to a PDF using another library like PDFBox
            document = PDDocument.load(new File("sample.pdf"));
        } finally {
            if (document != null) try { document.close(); } catch (Exception e) {}
        }
    }
}