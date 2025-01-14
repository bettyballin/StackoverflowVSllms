import java.lang.String;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

public class TransformExample {
    public static void main(String[] args) throws Exception {
        // Specify the Xalan TransformerFactory explicitly
        String factory = "org.apache.xalan.processor.TransformerFactoryImpl";
        System.setProperty("javax.xml.transform.TransformerFactory", factory);

        // Create a TransformerFactory instance
        TransformerFactory tffactory = TransformerFactory.newInstance(factory, null);
        
        // Load the XML and XSLT
        String xmlStr="<your><xml>data</xml></your>";
        String xslStr="<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'><xsl:template match='/'>transformed data</xsl:template></xsl:stylesheet>";

        StreamSource xml = new StreamSource(new StringReader(xmlStr));
        StreamSource xsl = new StreamSource(new StringReader(xslStr));

        // Create a Transformer instance
        Transformer transformer = tffactory.newTransformer(xsl);

        // Transform the XML and store in a result stream
        StreamResult result = new StreamResult(System.out);
        transformer.transform(xml, result);
    }
}