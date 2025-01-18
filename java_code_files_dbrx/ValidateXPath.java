import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.XMLConstants;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class ValidateXPath {
    public static void main(String[] args) throws Exception {
        boolean isValid = true;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setNamespaceAware(true); // important!! use namespace
        Document schemaDoc = dbFactory.newDocumentBuilder().parse(new File("yourSchemaFile.xsd"));
        XPath xpathEvaluator = XPathFactory.newInstance().newXPath();

        // Set NamespaceContext for XPath evaluator
        xpathEvaluator.setNamespaceContext(new NamespaceContext() {
            public String getNamespaceURI(String prefix) {
                if ("xs".equals(prefix)) {
                    return "http://www.w3.org/2001/XMLSchema";
                } else {
                    return XMLConstants.NULL_NS_URI;
                }
            }

            public String getPrefix(String namespaceURI) {
                throw new UnsupportedOperationException();
            }

            public Iterator getPrefixes(String namespaceURI) {
                throw new UnsupportedOperationException();
            }
        });

        String[] elementsInXPath = parseYourExpression("/RootData/FiirstChild/FirsstGrandChild".split("/"));
        for (int i = 1; i < elementsInXPath.length; i++) {
            String xpathForCheckingElementExistence = "//xs:element[@name='" + elementsInXPath[i]
                    + "']/ancestor-or-self::*/parent::xs:"
                    + (isNestedComplexType(schemaDoc) ? "*" : ("complex|simple")); // complex or simple type depending on if it a nested complex element
            NodeList nodeList = (NodeList) xpathEvaluator.evaluate(xpathForCheckingElementExistence, schemaDoc, XPathConstants.NODESET);
            if (nodeList == null || nodeList.getLength() == 0) {
                isValid = false; // failed validation as the XPath had an invalid element according to schema
                break; // quit early for efficiency since we already know it's wrong!
            } else {
                // keep checking next elements...
            }
        }
        // Output the result
        if (isValid) {
            System.out.println("The XPath is valid according to the schema.");
        } else {
            System.out.println("The XPath is invalid according to the schema.");
        }
    }

    private static String[] parseYourExpression(String[] elements) {
        // For this example, simply return the array as is
        return elements;
    }

    private static boolean isNestedComplexType(Document schemaDoc) {
        // Placeholder implementation
        // In a real scenario, you would analyze the schemaDoc to determine if it's a nested complex element
        return false;
    }
}