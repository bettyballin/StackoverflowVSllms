import org.apache.pdfbox.pdmodel.PDDocument;
import java.io.File;
import java.io.IOException;

public class SafePDFProcessor {

    public static boolean isValidPDF(File file) {
        try (PDDocument document = PDDocument.load(file)) {
            return true; // If loading succeeds, it's likely a valid PDF
        } catch (IOException e) {
            System.err.println("Error validating PDF: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        File file = new File("example.pdf");
        if (isValidPDF(file)) {
            System.out.println("The file is a valid PDF.");
            // Proceed with text extraction
        } else {
            System.out.println("The file is not a valid PDF.");
        }
    }
}