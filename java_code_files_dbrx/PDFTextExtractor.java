import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFTextExtractor {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please provide the PDF file path as a command-line argument.");
            System.exit(1);
        }

        try {
            PDDocument document = PDDocument.load(new File(args[0]));
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            String extractedText = stripper.getText(document);
            document.close();

            // You can print the extracted text or use it as needed
            System.out.println(extractedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}