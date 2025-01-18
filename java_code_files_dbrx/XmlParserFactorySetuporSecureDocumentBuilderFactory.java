import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParserFactorySetuporSecureDocumentBuilderFactory {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;

    public XmlParserFactorySetuporSecureDocumentBuilderFactory() throws ParserConfigurationException {
        factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false); // Disable validation against internal/external schemas or DTDs.
        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false); // Disable parsing external DTDs.
        factory.setExpandEntityReferences(false); // Restrict DocumentBuilder from resolving external entities, even if they appear in the parsed XML data.
        builder = factory.newDocumentBuilder();
    }

    public static void main(String[] args) {
    }
}