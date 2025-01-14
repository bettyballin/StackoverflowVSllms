import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class HtmlToPdfConverter {
    public static void main(String[] args) throws Exception {
        String html = "<html><body><h1>This is a header</h1><p>Normal text and <b>bold</b> text.</p></body></html>";
        
        // Parse HTML with Jsoup
        org.jsoup.nodes.Document jsoupDocument = Jsoup.parse(html);
        Elements elements = jsoupDocument.body().getAllElements();

        // Create an iText PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
        document.open();

        for (Element element : elements) {
            String text = element.ownText();
            
            if (text.isEmpty()) continue;

            Font font;
            if ("b".equalsIgnoreCase(element.tagName())) { // Check for bold tag
                font = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
            } else {
                font = new Font(FontFamily.HELVETICA, 12, Font.NORMAL);
            }

            document.add(new Phrase(text, font));
        }
        
        document.close();
    }
}