import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfOffsetFinder {
    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("path/to/your/document.pdf"));
        String searchString = "somestring";

        for (PDPage page : document.getPages()) {
            PDPageContentStream contentStream = new PDPageContentStream(document, page, PDPageContentStream.AppendMode.APPEND, false);
            PDFont font = PDType1Font.HELVETICA;
            contentStream.beginText();
            contentStream.newLineAtOffset(0, 0);
            contentStream.showText(searchString);
            contentStream.endText();

            Rectangle2D rect = contentStream.getGraphicsState().getTextMatrix().createTransformedShape(new Rectangle2D.Float(0, 0, searchString.length() * font.getAverageFontWidth(), font.getFontHeight())).getBounds2D();

            System.out.println("Found match at: " + rect.getMinX() + ", " + rect.getMinY() + ", " + rect.getMaxX() + ", " + rect.getMaxY());
            contentStream.close();
        }

        document.close();
    }
}