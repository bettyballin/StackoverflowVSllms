import java.lang.String;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import javax.xml.transform.dom.DOMSource;

public class XmlMerger {
  public static void main(String[] args) throws Exception {
    // Create an XSLT transformer
    TransformerFactory factory = TransformerFactory.newInstance();
    Transformer transformer = factory.newTransformer(new StreamSource("merge.xsl"));
    
    // Create an empty XML document
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    
    // Apply the XSLT stylesheet to the empty document
    transformer.transform(new DOMSource(doc), new StreamResult(System.out));
  }
}