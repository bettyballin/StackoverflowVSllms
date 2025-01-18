import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.*;

public class Main {
    public String getHTMLFromPDF(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            PDDocument document = PDDocument.load(fis);
            PDFTextStripper stripper = new PDFTextStripper();
            String textVersionOfDoc = stripper.getText(document); // Extract plain text from the PDF file
            document.close();

            return "<html><body>" + textVersionOfDoc + "</body></html>";
        } catch (IOException e) {
            // Exception handling code here
            return null;
        }
    }
}