import java.lang.String;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XmlDiff_1 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc1 = builder.parse(new File("file1.xml"));
        Document doc2 = builder.parse(new File("file2.xml"));

        NodeList list1 = doc1.getElementsByTagName("*");
        NodeList list2 = doc2.getElementsByTagName("*");

        // Compare the number of elements
        if (list1.getLength() != list2.getLength()) {
            System.out.println("Different number of elements");
        }

        // Compare the elements themselves
        for (int i = 0; i < list1.getLength(); i++) {
            Element elem1 = (Element) list1.item(i);
            Element elem2 = (Element) list2.item(i);

            if (!elem1.getTagName().equals(elem2.getTagName())) {
                System.out.println("Different element names");
            }

            // Compare the attributes and text content of the elements
            // ...
        }
    }
}