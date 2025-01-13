/*
 * Decompiled with CFR 0.152.
 */
import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

static class XmlValidator.1
implements EntityResolver {
    final /* synthetic */ String val$dtdFile;

    XmlValidator.1(String string) {
        this.val$dtdFile = string;
    }

    @Override
    public InputSource resolveEntity(String string, String string2) throws SAXException, IOException {
        return new InputSource(new FileInputStream(this.val$dtdFile));
    }
}
