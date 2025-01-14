import java.lang.String;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToImageConverter {

    public static void main(String[] args) {
        String pdfPath = "path/to/your/input.pdf";
        String outputDir = "path/to/output/images/";

        try (PDDocument document = PDDocument.load(new File(pdfPath))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300); // DPI can be adjusted
                ImageIO.write(bim, "PNG", new File(outputDir + "page_" + (page + 1) + ".png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}