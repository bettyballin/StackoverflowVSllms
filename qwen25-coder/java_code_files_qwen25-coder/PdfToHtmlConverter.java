import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfToHtmlConverter {
    public static void main(String[] args) throws Exception {
        try (PDDocument document = PDDocument.load(new File("input.pdf"))) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            System.out.println(text); // This is where you could convert the text to HTML.
        }
    }
}