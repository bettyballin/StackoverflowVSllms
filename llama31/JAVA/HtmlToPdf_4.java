import java.io.File;
import java.io.FileOutputStream;
import org.xhtmlrenderer.pdf.ITextRenderer;

public class HtmlToPdf_4_4 {
    public static void main(String[] args) throws Exception {
        String inputFile = "input.html";
        String outputFile = "output.pdf";

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(inputFile));
        renderer.layout();
        renderer.createPDF(new FileOutputStream(outputFile));
    }
}