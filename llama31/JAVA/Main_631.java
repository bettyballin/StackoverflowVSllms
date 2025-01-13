import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;

public class Main_631 {
    public static void main(String[] args) {
        // Initialize Tesseract
        Tesseract tesseract = new Tesseract();

        try {
            // Perform OCR on a PDF page
            File pdfPage = new File("path/to/pdf/page.png");
            String extractedText = tesseract.doOCR(pdfPage);
            System.out.println(extractedText);
        } catch (TesseractException e) {
            System.err.println("Error occurred during OCR: " + e.getMessage());
        }
    }
}