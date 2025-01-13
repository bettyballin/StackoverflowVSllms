import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

import java.io.File;

public class Main_424 {
    public static void main(String[] args) throws Exception {
        String linkText = "programming questions site";
        String xpathExpr = "//a[text()='" + linkText + "']/@href";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("your-html-file.html"));

        XPath xPath = XPathFactory.newInstance().newXPath();
        String url = (String) xPath.evaluate(xpathExpr, document, XPathConstants.STRING);

        System.out.println(url); // prints "http://stackoverflow.com"
    }
}