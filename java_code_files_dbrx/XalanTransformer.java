import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamSource;

public class XalanTransformer {

    String xsltFile = "/path/to/your/xsl/styles.xsl";
    StreamSource xmlSource = new StreamSource("/path/to/database/or/xml/document");

    String xalanProviderString = "com...jakarta.org";

    {
        System.setProperty("javax.xml.transform.TransformerFactory", xalanProviderString); // Setting XALAN provider string to use XALAN library instead of Saxon
    }

    TransformerFactory factory = TransformerFactory.newInstance();

    Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

    public static void main(String[] args) {
    }
}