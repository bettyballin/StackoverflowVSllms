import java.lang.String;
// Example custom parser in Java
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class CustomParser {
  public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File("example.xml"));
    Element root = document.getDocumentElement();
    String title = root.getElementsByTagName("title").item(0).getTextContent();
    System.out.println("<html><body><h1>" + title + "</h1></body></html>");
  }
}