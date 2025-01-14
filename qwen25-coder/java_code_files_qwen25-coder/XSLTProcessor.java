import java.lang.String;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTProcessor {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xslt = new StreamSource("your-stylesheet.xsl");
        Transformer transformer = factory.newTransformer(xslt);

        Source text = new StreamSource("input-xml.xml");
        Result result = new StreamResult(System.out);
        transformer.transform(text, result);
    }
}