import java.io.InputStream;
import java.io.FileInputStream;
import org.xml.sax.ContentHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.AutoDetectParser;

public class MainClass_3 {
    public static void main(String[] args) throws Exception{
        InputStream stream = new FileInputStream("path/to/input.txt"); // or URL url, Path path
        ContentHandler handler = new DefaultHandler(); // use the appropriate ContentHandler
        Metadata metadata = new Metadata();
        Parser parser = new AutoDetectParser();
        try {
            parser.parse(stream, handler, metadata);
            String detectedCharset = metadata.get("charset"); // you can now print this out or save it as a String. It should tell you the charset used.
        } catch (Exception ex) { /* handle exception */}
    }
}