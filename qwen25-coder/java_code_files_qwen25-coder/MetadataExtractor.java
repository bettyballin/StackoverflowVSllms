import org.apache.tika.Tika;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MetadataExtractor {
    public static void main(String[] args) throws IOException, SAXException {
        File file = new File("path/to/your/media/file.mp3");
        BodyContentHandler handler = new BodyContentHandler(-1);
        AutoDetectParser parser = new AutoDetectParser();
        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(file);

        ParseContext parseCtx = new ParseContext();
        parser.parse(inputstream, handler, metadata, parseCtx);

        for (String name : metadata.names()) {
            System.out.println(name + ": " + metadata.get(name));
        }
    }
}