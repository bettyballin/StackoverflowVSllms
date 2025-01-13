import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextExtractor;
import org.apache.pdfbox.text.TextPosition;

import java.awt.geom.Rectangle2D;

public class TextBoundsExtractor {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        PDDocument document = PDDocument.load(new File("input.pdf"));

        // Iterate through each page
        for (PDPage page : document.getPages()) {
            // Extract text from the page
            PDFTextExtractor extractor = new PDFTextExtractor(page);
            String text = extractor.getText();

            // Get the text positions (bounding rectangles) for each word
            List<TextPosition> textPositions = extractor.getTextPositions();

            // Iterate through each text position (word)
            for (TextPosition textPosition : textPositions) {
                // Get the bounding rectangle for the word
                Rectangle2D bounds = textPosition.getBoundingBox();

                // Process the bounding rectangle as needed
                System.out.println("Word: " + textPosition.getUnicode() + ", Bounds: " + bounds);
            }
        }

        // Close the document
        document.close();
    }
}