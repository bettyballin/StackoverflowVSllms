import java.lang.String;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class XmlReader_1 {
    public static void main(String[] args) throws Exception {
        File input = new File("input.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(input);
        // now you can use the Document object to access your data
    }
}