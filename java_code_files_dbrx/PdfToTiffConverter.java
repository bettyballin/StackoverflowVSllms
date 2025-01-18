import java.lang.String;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class PdfToTiffConverter {
    public static void main(String[] args) throws IOException {
        PDDocument document = PDDocument.load(new File("path/to/your/pdf")); // Replace with your PDF's path
        PDFRenderer renderer = new PDFRenderer(document);
        int numberOfPagesToConvert = document.getNumberOfPages();

        for (int pageIndex = 0; pageIndex < numberOfPagesToConvert; ++pageIndex) {
            BufferedImage bufferedImage = renderer.renderImageWithDPI(pageIndex, 300); // Increase DPI to improve the quality of TIFF images if needed
            RenderedImage renderedImage = convertBufferedImageToTIFF(bufferedImage);

            File outputFile = new File("path/to/output/" + pageIndex + ".tiff"); // Replace with your desired file path and name for each TIFF image
            ImageIO.write(renderedImage, "tiff", outputFile);
        }
    }

    private static RenderedImage convertBufferedImageToTIFF(final BufferedImage source) {
        return new BufferedImage((int) (source.getWidth()), (int)(source.getHeight()), BufferedImage.TYPE_BYTE_GRAY); // Grayscale images, change to TYPE_INT_RGB if you need color
    }
}