import org.xhtmlrenderer.pdf.ITextRenderer;

public class PdfGenerator {
    public static void main(String[] args) {
        // assuming 'html' is the HTML content you want to convert
        String html = "<html><body><h1>Hello World!</h1></body></html>";

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF("output.pdf");
    }
}