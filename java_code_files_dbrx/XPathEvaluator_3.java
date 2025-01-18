import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.io.File;
import javax.xml.parsers.*;

public class XPathEvaluator_3 {

    public static void main(String[] args) throws Exception {
        String expression = "/xml/level1/level2";
        XPathExpression xpathExp = XPathFactory.newInstance().newXPath().compile(expression);

        // Parse the XML document
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("input.xml"));
        doc.getDocumentElement().normalize();

        NodeList nodeListCDATA = (NodeList) xpathExp.evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeListCDATA.getLength(); i++) {
            Element tempELe = (Element) nodeListCDATA.item(i); // Replace with any element you would like to have the CDATA of
            System.out.println("CDATA: " + ((CharacterData) tempELe.getFirstChild()).getData()); // Replace with whatever you'd like to do with the data
        }
    }
}