import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import java.io.File;

public class MyDocumentParser {

    private static Document getDoc(File f, String docId) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setValidating(false);

        // Create DocumentBuilder
        DocumentBuilder db = dbf.newDocumentBuilder();

        // Set the entity resolver to ignore DTDs
        db.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) {
                return new InputSource();
            }
        });

        Document doc = db.parse(f);

        return doc;
    }
}