import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor;
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.listener.TextExtractionStrategy;
import com.itextpdf.kernel.pdf.canvas.parser.TextRenderInfo;

import java.util.List;
import java.util.ArrayList;

public class PdfExample {
    public static void main(String[] args) {
        String src = "path/to/pdf.pdf";
        try {
            PdfReader reader = new PdfReader(src);
            PdfDocument document = new PdfDocument(reader);
            MyLocationTextExtractionStrategy strategy = new MyLocationTextExtractionStrategy();
            PdfCanvasProcessor parser = new PdfCanvasProcessor(strategy);
            parser.processPageContent(document.getFirstPage());
            String currentText = strategy.getResultantText();
            List<Rectangle> rectangles = strategy.getBBoxes(); // this gives you a list of bounding boxes for each text chunk in the order they appear on page
            // You can add your logic here to handle the extracted text and bounding boxes
            document.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyLocationTextExtractionStrategy extends LocationTextExtractionStrategy {

    private List<Rectangle> rectangles = new ArrayList<>();

    @Override
    public void renderText(TextRenderInfo renderInfo) {
        super.renderText(renderInfo);
        Rectangle rect = renderInfo.getAscentLine().getBoundingRectangle();
        rectangles.add(rect);
    }

    public List<Rectangle> getBBoxes() {
        return rectangles;
    }
}