import java.lang.String;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.InputSource;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLPerformanceTest {

    public static void testSAX(String filePath) throws Exception {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        long startTime = System.currentTimeMillis();
        parser.parse(new InputSource(Files.newInputStream(Paths.get(filePath))), new DefaultHandler());
        long endTime = System.currentTimeMillis();
        System.out.println("SAX Parsing took: " + (endTime - startTime) + " ms");
    }

    public static void testStAX(String filePath) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        long startTime = System.currentTimeMillis();
        XMLStreamReader reader = factory.createXMLStreamReader(Files.newInputStream(Paths.get(filePath)));
        while (reader.hasNext()) {
            int event = reader.next();
        }
        long endTime = System.currentTimeMillis();
        reader.close();
        System.out.println("StAX Parsing took: " + (endTime - startTime) + " ms");
    }

    public static void main(String[] args) throws Exception {
        String xmlFilePath = "large-document.xml";
        testSAX(xmlFilePath);
        testStAX(xmlFilePath);
    }
}