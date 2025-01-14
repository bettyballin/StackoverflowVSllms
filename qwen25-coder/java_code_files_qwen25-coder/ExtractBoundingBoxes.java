import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

public class ExtractBoundingBoxes {
    public static void main(String[] args) throws IOException {
        PDDocument document = null;
        try {
            document = PDDocument.load(new File("your-searchable-pdf.pdf"));
            PDFTextStripperByArea textStripper = new PDFTextStripperByArea();
            textStripper.setSortByPosition(true);

            for (int p = 0; p < document.getNumberOfPages(); p++) {
                textStripper.extractRegions(document.getPage(p));
                System.out.println("Page: " + (p + 1));

                for (String key : textStripper.getRegions().keySet()) {
                    String singleRegionText = textStripper.getTextForRegion(key);
                    if (singleRegionText != null) {
                        Rectangle boundingBox = textStripper.getRegionBounds(key);
                        System.out.println("Region: " + key + ", Text: " + singleRegionText + ", Bounding Box: " + boundingBox);
                    }
                }
            }

        } finally {
            if (document != null) {
                document.close();
            }
        }
    }
}