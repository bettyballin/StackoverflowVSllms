import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.XMLConstants;

public class XmlSecurityConfigurer {
    public static void main(String[] args) throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setFeature(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        dbf.setFeature(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
    }
}