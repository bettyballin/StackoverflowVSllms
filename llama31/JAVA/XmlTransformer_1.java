import java.lang.String;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlTransformer_1 {
    public static void main(String[] args) throws TransformerException {
        // Load internal XML
        Source internalXml = new StreamSource("internal.xml");

        // Load XSLT transformation
        Source xslt = new StreamSource("transform.xsl");

        // Create transformer
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xslt);

        // Transform internal XML to external XML
        Result externalXml = new StreamResult("external.xml");
        transformer.transform(internalXml, externalXml);
    }
}