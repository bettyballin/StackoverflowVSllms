import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.ocr.PDFBoxOCR;
import java.io.File;
import java.io.IOException;

public class Main_626 {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        PDDocument pdfDocument = PDDocument.load(new File("path/to/pdf.pdf"));

        // Perform OCR on the PDF
        PDFBoxOCR ocr = new PDFBoxOCR();
        String extractedText = ocr.getText(pdfDocument);

        // Print the extracted text
        System.out.println(extractedText);

        // Close the PDF document
        pdfDocument.close();
    }
}