import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Source;
import java.io.File;
import javax.xml.transform.Result;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import javax.xml.transform.stream.StreamSource;

public class TransformXML {

    public static void main(String[] args) throws Exception {
        // Set Xalan as the transformer factory explicitly
        System.setProperty("javax.xml.transform.TransformerFactory", "org.apache.xalan.processor.TransformerFactoryImpl");

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Source xslt = new StreamSource(new File("/path/to/your/xsltfile.xslt"));
        Transformer transformer = tFactory.newTransformer(xslt);

        // Assuming you have a DOMSource object named xmlInput
        // Let's create the xmlDocument object
        Document xmlDocument = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("/path/to/your/xmlfile.xml"));
        Source xmlInput = new DOMSource(xmlDocument);
        Result outputTarget = new StreamResult(System.out);

        transformer.transform(xmlInput, outputTarget);
    }
}