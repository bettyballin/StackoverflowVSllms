import org.apache.axis.encoding.Deserializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class BOMIgnoringDeserializer extends Deserializer {
    @Override
    public Object parse(InputStream inputStream) throws IOException, SAXException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setEncoding("UTF-8");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        XMLReader reader = factory.newSAXParser().getXMLReader();

        // Ignore BOM character
        reader.setFeature("http://apache.org/xml/features/allow-java-encodings", true);

        return reader.parse(inputSource);
    }

    public static void main(String[] args) {
    }
}