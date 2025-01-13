import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;

public class PdfToImage {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        PDDocument document = PDDocument.load(new File("input.pdf"));

        // Create a PDF renderer
        PDFRenderer renderer = new PDFRenderer(document);

        // Iterate through the pages and save them as images
        for (int i = 0; i < document.getNumberOfPages(); i++) {
            BufferedImage image = renderer.renderImage(i, 300, ImageType.RGB);
            File outputFile = new File("page-" + (i + 1) + ".png");
            ImageIO.write(image, "png", outputFile);
        }

        // Close the document
        document.close();
    }
}