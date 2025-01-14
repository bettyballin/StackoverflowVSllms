import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class HtmlToPdfConverter_1 {

    public static void convertHtmlContentToPdf(String htmlContent, String outputPdfPath) throws Exception {
        OutputStream outputStream = new FileOutputStream(new File(outputPdfPath));
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(htmlContent);
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
    }

    public static void main(String[] args) {
        try {
            // Example HTML content
            String htmlContent = "<html><head><title>My PDF Page</title></head>"
                    + "<body><h1>Hello World!</h1><p>This is a test.</p></body></html>";
            
            // Convert to PDF
            convertHtmlContentToPdf(htmlContent, "output.pdf");
            System.out.println("PDF created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}