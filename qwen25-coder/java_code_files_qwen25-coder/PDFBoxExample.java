import java.lang.String;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class PDFBoxExample {
    public static void main(String[] args) throws Exception {
        File file = new File("example.pdf");
        PDDocument document = PDDocument.load(file);

        // Extract text and get bounding boxes
        PDFTextStripper stripper = new PDFTextStripper() {
            @Override
            protected void writeString(String str, List<TextPosition> textPositions) throws IOException {
                for (TextPosition text : textPositions) {
                    System.out.println("String ["
                        + text.getXDirAdj() + ", "
                        + text.getYDirAdj() + " fs="
                        + text.getFontSize() + " xscale="
                        + text.getXScale() + "] "
                        + text.getUnicode());
                }
            }
        };
        stripper.setSortByPosition(true);

        for (int pageNumber = 1; pageNumber <= document.getNumberOfPages(); pageNumber++) {
            stripper.setStartPage(pageNumber);
            stripper.setEndPage(pageNumber);
            System.out.println("Page: " + pageNumber);
            stripper.getText(document);
        }

        // Extract image bounding boxes
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        int pageCount = document.getNumberOfPages();
        for (int pageIdx = 0; pageIdx < pageCount; ++pageIdx) {
            BufferedImage bim = pdfRenderer.renderImageWithDPI(pageIdx, 300); // specify resolution as you need
            // This example doesn't directly extract image bounding boxes, but you can use document.getPage(pageIdx).getResources().getXObjectNames() to access images and then calculate their bounding boxes.
        }

        document.close();
    }
}