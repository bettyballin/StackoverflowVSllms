import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LocalEntityResolver implements EntityResolver {
    @Override
    public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
        if (systemId.startsWith("http://www.w3.org/TR/html4/")) {
            return new InputSource(new ByteArrayInputStream(new byte[0]));
        } else {
            return null;
        }
    }
}