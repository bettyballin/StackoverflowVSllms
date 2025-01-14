import java.lang.String;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathExample_6 {
    public static void main(String[] args) {
        try {
            String xmlPath = "path/to/your/xmlfile.xml";
            
            // Load and parse the XML file
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document document = docBuilder.parse(xmlPath);
            document.getDocumentElement().normalize();

            // Initialize XPath
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            // Your XPath query
            String expression = "//your/xpath/expression";  // Replace with actual query
            
            // Execute the XPath query and get the NodeList
            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);

            // Process the result node list as necessary
            if (nodeList.getLength() > 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    System.out.println("Found node: " + nodeList.item(i));
                }
            } else {
                System.out.println("No nodes found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}