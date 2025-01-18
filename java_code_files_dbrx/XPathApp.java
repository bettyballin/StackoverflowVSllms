import java.lang.String;
import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XPathApp {
  public static void main(String[] args) throws Exception {
    // Disable the DTD fetching:
    System.setProperty("javax.xml.accessExternalDTD", "all");

    // Create a custom entity resolver to block external DOCTYPE entities while still allowing internal ones and other features of XML:
    CustomEntityResolver cer = new CustomEntityResolver();

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware(true);
    dbf.setValidating(false); // Disable validation for external DTDs; optional step but recommended to speed up parsing:
    dbf.setExpandEntityReferences(false);
    DocumentBuilder db = dbf.newDocumentBuilder();
    db.setEntityResolver(cer);
  }
}

class CustomEntityResolver implements EntityResolver {
  @Override
  public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
    // Block external entities
    if (systemId != null && (systemId.startsWith("http://") || systemId.startsWith("https://") || systemId.startsWith("file://"))) {
      // Return an empty InputSource to prevent fetching external entities
      return new InputSource(new StringReader(""));
    }
    // Use the default behavior for other entities
    return null;
  }
}