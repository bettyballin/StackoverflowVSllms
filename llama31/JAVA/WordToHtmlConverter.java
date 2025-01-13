import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

public class WordToHtmlConverter {
    public static void main(String[] args) throws IOException, TikaException {
        // Load the Word document
        XWPFDocument document = new XWPFDocument(new FileInputStream("input.docx"));

        // Create a Tika instance
        Tika tika = new Tika();

        // Convert the Word document to HTML
        String html = tika.parseToString(document);

        // Split the HTML into separate files for each page
        int pageCount = 3; // hardcoded page count as XWPFDocument doesn't have a getPageCount() method
        for (int i = 0; i < pageCount; i++) {
            String pageHtml = getPageHtml(html, i);
            writePageHtml(pageHtml, "output-" + (i + 1) + ".html");
        }
    }

    private static String getPageHtml(String html, int pageIndex) {
        // Implement your own page splitting logic here
        // For simplicity, this example just splits the HTML into equal parts
        int pageStartIndex = pageIndex * (html.length() / 3);
        int pageEndIndex = (pageIndex + 1) * (html.length() / 3);
        if(pageIndex == 2) {
            pageEndIndex = html.length();
        }
        return html.substring(pageStartIndex, pageEndIndex);
    }

    private static void writePageHtml(String html, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(new File(filename))) {
            writer.write(html);
        }
    }
}