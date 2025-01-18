import javax.xml.transform.*;
import javax.xml.transform.stream.StreamSource;

public class XSLTTransformerFactory {
    // Create the transformerFactory with exslt extension support
    TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
    // Create a new transformer from the stylesheet as a StreamSource
    StreamSource xsltSource = new StreamSource(xsltFile);
    Transformer transformerXSLT;

    {
        try {
            transformerXSLT = factory.newTransformer(xsltSource);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }

    String xsltFile = "path/to/stylesheet.xslt";

    public static void main(String[] args) {
    }
}