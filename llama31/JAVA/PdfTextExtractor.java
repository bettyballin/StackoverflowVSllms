import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextProcessor;

import java.io.File;
import java.io.IOException;

public class PdfTextExtractor {
    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("example.pdf"));
        String text = PDFTextProcessor.getText(document);
        System.out.println(text);
        document.close();
    }
}