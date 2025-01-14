import nu.xom.Builder;
import nu.xom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

import java.io.StringReader;

public class SecureParser {
    public static void main(String[] args) throws Exception {
        Builder builder = new Builder();
        // Disable DTD loading by providing a custom EntityResolver
        builder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) {
                // Returning an empty InputSource prevents the parser from downloading or loading any external entity.
                return new InputSource(new StringReader(""));
            }
        });

        String xhtmlContent = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\"\n" +
                              "\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                              "<html xmlns=\"http://www.w3.org/1999/xhtml\"><body><p>Hello World!</p></body></html>";

        Document doc = builder.build(new StringReader(xhtmlContent));
        System.out.println(doc.toXML());
    }
}