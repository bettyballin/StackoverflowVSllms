import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.InputSource;

public class Main_102 {
    public static void main(String[] args) throws Exception {
        String xml = "<AllCharges>\n" +
                "   <Charge>\n" +
                "     <ID>1</ID>\n" +
                "     <Type>A</Type>\n" +
                "   </Charge>\n" +
                "   <Charge>\n" +
                "     <ID>2</ID>\n" +
                "     <Type>A</Type>\n" +
                "   </Charge>\n" +
                "   <Charge>\n" +
                "     <ID>3</ID>\n" +
                "     <Type>B</Type>\n" +
                "   </Charge>\n" +
                "</AllCharges>";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xml));
        Document doc = builder.parse(is);

        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();
        XPathExpression expr = xpath.compile("/AllCharges/Charge[Type='A']");

        NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
        Element allChargesElement = doc.createElement("AllCharges");
        for(int i = 0; i < nl.getLength(); i++){
            Node node = nl.item(i).cloneNode(true);
            allChargesElement.appendChild(node);
        }

        // To print the result
        Transformer xform = TransformerFactory.newInstance().newTransformer();
        xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        xform.transform(new DOMSource(allChargesElement), new StreamResult(System.out));
    }
}