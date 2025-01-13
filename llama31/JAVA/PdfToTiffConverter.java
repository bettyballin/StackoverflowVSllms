import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfToTiffConverter {

    public static void main(String[] args) throws IOException {
        // Load the PDF document
        PDDocument pdfDocument = PDDocument.load(new File("input.pdf"));

        // Create a PDF renderer
        PDFRenderer pdfRenderer = new PDFRenderer(pdfDocument);

        // Iterate through the pages and convert to TIFF
        for (int page = 0; page < pdfDocument.getNumberOfPages(); page++) {
            BufferedImage bufferedImage = pdfRenderer.renderImage(page, ImageType.RGB);
            File outputFile = new File("output_" + page + ".tiff");
            ImageIO.write(bufferedImage, "TIFF", outputFile);
        }

        // Close the PDF document
        pdfDocument.close();
    }
}