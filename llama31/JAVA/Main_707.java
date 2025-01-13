import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextProcessor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main_707 {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        try (PDDocument pdf = PDDocument.load(new File("input.pdf"))) {
            // Convert the PDF to text (not HTML, as PDFTextProcessor.getText() returns plain text)
            String text = PDFTextProcessor.getText(pdf);

            // Save the text to a file
            Files.write(new File("output.txt").toPath(), text.getBytes());
        }
    }
}