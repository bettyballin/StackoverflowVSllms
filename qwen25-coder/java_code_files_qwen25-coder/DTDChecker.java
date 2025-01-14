import java.io.IOException;
import java.lang.String;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class DTDChecker {
    public static boolean hasDoctype(InputSource input) throws SAXException, IOException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        // Create a handler that implements LexicalHandler
        LexicalHandler lexicalHandler = new DefaultHandler() {
            @Override
            public void startDTD(String name, String publicId, String systemId) throws SAXException {
                throw new SAXException("DOCTYPE found");
            }
        };
        // Set the LexicalHandler property on the reader
        reader.setProperty("http://xml.org/sax/properties/lexical-handler", lexicalHandler);
        // Set an empty ContentHandler
        reader.setContentHandler(new DefaultHandler());
        try {
            reader.parse(input);
            return false; // No DTD found
        } catch (SAXException e) {
            if ("DOCTYPE found".equals(e.getMessage())) {
                return true;
            }
            throw e;
        }
    }

    public static void main(String[] args) {
    }
}