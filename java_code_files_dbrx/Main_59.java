import java.util.regex.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Get XML document object...
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        Document doc = dbf.newDocumentBuilder().parse("tree.xml");
        XPath xpath = XPathFactory.newInstance().newXPath();

        // Retrieve the node value using XPath...
        String nodeContent = xpath.evaluate("/tree/nodea/nodeb", doc);

        // Apply regex to extract 'B' content...
        Pattern pattern = Pattern.compile("B=(.*?);"); // Define regex for matching B values.
        Matcher matcher = pattern.matcher(nodeContent);
        while (matcher.find()) {
            String bValue = matcher.group(1);   // This contains 'bar'
            System.out.println(bValue); // Output the extracted value
        }
    }
}