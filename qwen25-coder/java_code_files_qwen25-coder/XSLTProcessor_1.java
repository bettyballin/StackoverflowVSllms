import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class XSLTProcessor {
    public static void main(String[] args) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslt = new StreamSource("your-stylesheet.xsl");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("your-input.xml"));
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(System.out);

        Transformer transformer = factory.newTransformer(xslt);
        transformer.setParameter("color", "red");
        transformer.setParameter("number", "two");
        transformer.transform(source, result);
    }
}