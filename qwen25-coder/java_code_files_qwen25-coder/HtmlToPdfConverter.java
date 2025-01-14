import org.xhtmlrenderer.pdf.ITextRenderer;
import java.io.FileOutputStream;

public class HtmlToPdfConverter {
    public static void main(String[] args) throws Exception {
        String inputFile = "path/to/your/file.html";
        String outputFile = "output.pdf";

        // Initialize the renderer
        ITextRenderer renderer = new ITextRenderer();
        
        // Set the HTML file as input for the renderer
        renderer.setDocument(inputFile);
        renderer.layout();

        // Write the PDF to a file
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            renderer.createPDF(fos);
        }
    }
}