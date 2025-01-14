import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

public class ExtractBoundingBoxesWithIText {
    public static void main(String[] args) throws Exception {
        PdfReader reader = new PdfReader("your-searchable-pdf.pdf");
        int numPages = reader.getNumberOfPages();

        for (int p = 1; p <= numPages; p++) {
            System.out.println("Page: " + p);

            MyTextExtractionStrategy strategy = new MyTextExtractionStrategy();
            String currentText = PdfTextExtractor.getTextFromPage(reader, p, strategy);

            List<TextChunk> textChunks = strategy.getTextChunks();
            for (TextChunk chunk : textChunks) {
                System.out.println("Text: " + chunk.text + ", Bounding Box: " + chunk.boundingBox);
            }
        }

        reader.close();
    }

    static class MyTextExtractionStrategy implements TextExtractionStrategy {
        private List<TextChunk> textChunks = new ArrayList<TextChunk>();

        public String getResultantText() {
            return null; // Not needed
        }

        public void renderText(TextRenderInfo renderInfo) {
            String text = renderInfo.getText();
            Rectangle2D.Float boundingBox = renderInfo.getDescentLine().getBoundingRect();
            textChunks.add(new TextChunk(text, boundingBox));
        }

        public void renderImage(ImageRenderInfo renderInfo) {
            // Do nothing
        }

        public void beginTextBlock() {}
        public void endTextBlock() {}

        public List<TextChunk> getTextChunks() {
            return textChunks;
        }
    }

    static class TextChunk {
        String text;
        Rectangle2D.Float boundingBox;

        public TextChunk(String text, Rectangle2D.Float boundingBox) {
            this.text = text;
            this.boundingBox = boundingBox;
        }
    }
}