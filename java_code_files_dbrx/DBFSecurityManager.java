import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DBFSecurityManager {

    static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    static {
        try {
            dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Application entry point
    }
}