import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.ImageFormats;
import org.apache.commons.imaging.ImageWriteException;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PDFToTIFFConverter {

    public static void convert(String inputPdf, String outputTiff) throws IOException, ImageWriteException {
        try (PDDocument document = PDDocument.load(new File(inputPdf))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            int pageCount = document.getNumberOfPages();
            for (int page = 0; page < pageCount; ++page) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300);

                // Save the rendered image as TIFF
                Imaging.writeImage(bim, new File(outputTiff + "_page" + (page + 1) + ".tif"), ImageFormats.TIFF, null);
            }
        }
    }

    public static void main(String[] args) {
        try {
            convert("input.pdf", "output");
            System.out.println("Conversion completed successfully.");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}