import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import java.io.File;
import java.io.IOException;

public class Main_827 {
    public static void main(String[] args) throws TikaException, IOException {
        // Create a Tika instance and an HTML parser
        Tika tika = new Tika();
        HtmlParser parser = new HtmlParser();

        // Parse the HTML file
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();
        parser.parse(new File("example.html"), handler, metadata, context);

        // Print the extracted metadata
        System.out.println(metadata);
    }
}