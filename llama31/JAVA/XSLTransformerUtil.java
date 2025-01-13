import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;

public class XSLTransformerUtil {
    private static TransformerFactory factory;

    static {
        try {
            factory = TransformerFactory.newInstance("org.apache.xalan.xsltc.trax.TransformerFactoryImpl", null);
        } catch (TransformerFactoryConfigurationError e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    }
}