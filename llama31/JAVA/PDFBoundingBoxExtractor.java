import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDFontDescriptor;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class PDFBoundingBoxExtractor {
    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("input.pdf"));
        PDPage page = document.getPage(0);

        // Get the page content stream
        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        // Iterate over the page content stream
        for (Object object : page.getContentStreams()) {
            if (object instanceof PDPageContentStream) {
                PDPageContentStream cs = (PDPageContentStream) object;
                for (Object obj : cs.getTokens()) {
                    if (obj instanceof PDFont) {
                        // Text object
                        PDFont font = (PDFont) obj;
                        PDFontDescriptor fontDescriptor = font.getFontDescriptor();
                        float fontSize = fontDescriptor.getFontSize();
                        float textWidth = fontDescriptor.getAverageWidth() * fontSize;
                        float textHeight = fontDescriptor.getCapHeight() * fontSize;

                        // Calculate the bounding box of the text
                        float x = cs.getCurrentPosition().getX();
                        float y = cs.getCurrentPosition().getY();
                        float width = textWidth;
                        float height = textHeight;

                        System.out.println("Text bounding box: [" + x + ", " + y + ", " + width + ", " + height + "]");
                    } else if (obj instanceof PDXObject) {
                        // Image or path object
                        PDXObject xobject = (PDXObject) obj;
                        if (xobject instanceof PDImageXObject) {
                            // Image
                            PDImageXObject image = (PDImageXObject) xobject;
                            float x = cs.getCurrentPosition().getX();
                            float y = cs.getCurrentPosition().getY();
                            float width = image.getWidth();
                            float height = image.getHeight();

                            System.out.println("Image bounding box: [" + x + ", " + y + ", " + width + ", " + height + "]");
                        } else {
                            // Path
                            // ...
                        }
                    }
                }
            }
        }
        document.close();
    }
}