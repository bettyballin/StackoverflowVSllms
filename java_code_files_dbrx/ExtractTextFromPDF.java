import java.io.InputStream;
import java.io.FileInputStream;

import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.html.HTMLParser;

import org.xml.sax.ContentHandler;

public class ExtractTextFromPDF {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("path_to_your_pdf");
            ContentHandler handler = new BodyContentHandler();
            Metadata metadata = new Metadata();
            ParseContext pcontext = new ParseContext();
            HTMLParser htmlparser = new HTMLParser();
            htmlparser.parse(is, handler, metadata, pcontext);
            String extractedText = handler.toString(); // Extracted text from the PDF file
            System.out.println(extractedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}