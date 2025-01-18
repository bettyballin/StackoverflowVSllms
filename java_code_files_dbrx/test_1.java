import javax.xml.xpath.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class test_1 {
  public static void main(String[] args) throws Exception{
    // Create a DocumentBuilder
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    
    // Parse an XML document
    String xmlContent = "<bookstore><book><title>Book 1</title><price>45</price></book></bookstore>";
    InputStream is = new ByteArrayInputStream(xmlContent.getBytes("UTF-8"));
    Document doc = dBuilder.parse(is);

    // Create XPath
    XPathFactory xPathFactory = XPathFactory.newInstance();
    XPath xPath = xPathFactory.newXPath();

    // Define XPath expression
    String expression = "/bookstore/book[price>35]/title"; //query string

    // Evaluate expression
    Object result = xPath.evaluate(expression, doc);

    // Output result
    System.out.println(result);
  }
}