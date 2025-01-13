import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.namespace.NamespaceContext;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;

public class Main_427 {
    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory instance
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder instance
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse your XML source into a Document object
            Document document = builder.parse(new InputSource("your-xml-file.xml"));

            // Get the NamespaceContext from the Document object
            NamespaceContext namespaceContext = new NamespaceContext() {
                @Override
                public String getNamespaceURI(String prefix) {
                    return document.getDocumentElement().getNamespaceURI();
                }

                @Override
                public String getPrefix(String namespaceURI) {
                    return null;
                }

                @Override
                public Iterator<String> getPrefixes(String namespaceURI) {
                    return null;
                }
            };

            // Use the NamespaceContext with your XPath expression
            XPath xpath = XPathFactory.newInstance().newXPath();
            xpath.setNamespaceContext(namespaceContext);

        } catch (ParserConfigurationException e) {
            System.out.println("Parser Configuration Exception: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX Exception: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }
    }
}