import java.io.IOException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class CustomEntityResolver implements EntityResolver {
    public InputSource resolveEntity(String pubId, String sysId) throws SAXException, IOException {
        if (sysId == null || "".equalsIgnoreCase(sysId)) { // if no DTD has been defined in XML file so fallback on local DTD resources:
            return null;
        } else { // Blocks external DOCTYPE entities while still allowing other features of XML like internal ones etc.:
            throw new SAXException("External Entity resolution must be blocked for security reasons.");
        }
    }
}