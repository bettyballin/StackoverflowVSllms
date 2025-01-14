import org.xhtmlrenderer.pdf.ITextRenderer;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;

import java.io.FileOutputStream;
import java.io.IOException;

public class MultiOrientationPDF {
    public static void main(String[] args) throws DocumentException, IOException {
        String outputFile = "output.pdf";

        // HTML content for the pages
        String[] htmlContents = {
            "<html><body>This is page 1</body></html>",
            "<html><body>This is page 2</body></html>",
            "<html><body>This is page 3</body></html>"
        };

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            ITextRenderer renderer = new ITextRenderer();

            // First two pages in landscape
            for (int i = 0; i < 2; i++) {
                renderer.setDocumentFromString(htmlContents[i]);
                renderer.getSharedContext().setPageSize(PageSize.A4.rotate());
                renderer.layout();
                renderer.createPDF(fos, i != 0);
            }

            // Pages from third onwards in portrait
            for (int i = 2; i < htmlContents.length; i++) {
                renderer.setDocumentFromString(htmlContents[i]);
                renderer.getSharedContext().setPageSize(PageSize.A4);
                renderer.layout();
                renderer.writeNextDocument();
                renderer.createPDF(fos, true);
            }

            renderer.finishPDF();
            fos.flush();
        }
    }
}