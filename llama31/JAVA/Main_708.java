import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.pdf2html.PdfToHtml;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main_708 {
    public static void main(String[] args) throws IOException {
        // Load the PDF document
        PdfDocument pdf = new PdfDocument(new PdfReader("input.pdf"));

        // Convert the PDF to HTML
        String html = PdfToHtml.convertPdfToHtml(pdf);

        // Save the HTML to a file
        Files.write(new File("output.html").toPath(), html.getBytes());
    }
}