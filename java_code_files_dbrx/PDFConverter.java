import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO; // Needed for ImageIO.write

public class PDFConverter {
    public void pdfToImages(String src, String dest) {
        try (PDDocument document = PDDocument.load(new File(src))) {
            PDFRenderer renderer = new PDFRenderer(document);
            for (int i = 0; i < document.getNumberOfPages(); ++i) {
                BufferedImage image = renderer.renderImageWithDPI(i, 300, ImageType.RGB);
                File file = new File(dest + "/page-" + (i + 1) + ".png");
                ImageIO.write(image, "png", file);
            }
        } catch (IOException e) {
            System.err.println("An IOException was encountered: ");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java PDFConverter <source-pdf-path> <destination-folder-path>");
            System.exit(1);
        }
        String src = args[0];
        String dest = args[1];
        PDFConverter converter = new PDFConverter();
        converter.pdfToImages(src, dest);
    }
}