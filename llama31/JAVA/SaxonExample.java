import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class SaxonExample {
    public static void main(String[] args) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl");
        Transformer transformer = factory.newTransformer(new StreamSource("transform.xsl"));
        transformer.transform(new StreamSource("input.xml"), new StreamResult(System.out));
    }
}