import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import java.io.File;

public class Main_798 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("books.xml"));

        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//author[contains(text(), 'Ritchie')]/text()";

        String fullName = (String) xPath.compile(expression).evaluate(document, XPathConstants.STRING);

        System.out.println(fullName); // prints "Ritchie, Dennis M."
    }
}