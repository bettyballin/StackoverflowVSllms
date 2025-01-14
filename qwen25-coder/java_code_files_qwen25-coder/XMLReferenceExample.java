import java.lang.String;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import javax.xml.xpath.*;

public class XMLReferenceExample {
    public static void main(String[] args) throws Exception {
        String xmlContent = "<Root>" +
                            "  <Holes>" +
                            "     <Hole id='1' dia='0.1' depth='2'/>" +
                            "     <Hole id='2' dia='0.2' depth='1.67'/>" +
                            "     <Hole id='3' dia='0.3' depth='0.44'/>" +
                            "  </Holes>" +
                            "  <Drill useHoleWithId='1'/>" +
                            "</Root>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new java.io.ByteArrayInputStream(xmlContent.getBytes()));

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        NodeList drillNodes = (NodeList) xpath.evaluate("/Root/Drill", doc, XPathConstants.NODESET);
        for (int i = 0; i < drillNodes.getLength(); i++) {
            Element drillElement = (Element) drillNodes.item(i);
            String holeId = drillElement.getAttribute("useHoleWithId");

            // Use XPath to find the Hole element with a matching id
            XPathExpression expr = xpath.compile("/Root/Holes/Hole[@id='" + holeId + "']");
            NodeList holeNodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            if (holeNodes.getLength() > 0) {
                Element holeElement = (Element) holeNodes.item(0);
                String dia = holeElement.getAttribute("dia");
                String depth = holeElement.getAttribute("depth");
                System.out.println("Hole with id '" + holeId + "' has diameter: " + dia + ", depth: " + depth);
            }
        }
    }
}