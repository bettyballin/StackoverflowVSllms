import org.pdfclown.documents.Document;
import org.pdfclown.documents.DocumentFactory;
import org.pdfclown.util.converter.pdfToHtml.PdfToHtml;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main_709 {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        Document pdf = DocumentFactory.loadDocument("input.pdf");

        // Convert the PDF to HTML
        String html = PdfToHtml.convert(pdf);

        // Save the HTML to a file
        Files.write(Paths.get("output.html"), html.getBytes());
    }
}