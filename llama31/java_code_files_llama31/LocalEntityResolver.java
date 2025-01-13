/*
 * Decompiled with CFR 0.152.
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class LocalEntityResolver
implements EntityResolver {
    @Override
    public InputSource resolveEntity(String string, String string2) throws SAXException, IOException {
        if (string2.startsWith("http://www.w3.org/TR/html4/")) {
            return new InputSource(new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }
}
