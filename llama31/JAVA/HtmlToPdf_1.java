import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlToPdf_1 {
    public static void main(String[] args) throws Exception {
        // assuming 'html' is the HTML content you want to convert
        String html = "<html><body><h1>Hello World!</h1></body></html>";

        Document doc = Jsoup.parse(html);
        PDDocument pdf = new PDDocument();
        pdf.addPage(new PDPage());
        // Note: You can't directly add a Jsoup Document to a PDPage.
        // You would need to use a library that can convert HTML to PDF, such as Flying Saucer.
        // For simplicity, this example just creates an empty PDF page.
        pdf.save("output.pdf");
        pdf.close();
    }
}