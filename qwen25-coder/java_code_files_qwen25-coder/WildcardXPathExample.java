import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

public class WildcardXPathExample {
    public static void main(String[] args) throws Exception {
        String xml = "<Configuration>\n"
                   + "  <Destinations>\n"
                   + "    <Destination name=\"DEST1\">\n"
                   + "      <From>AMA*</From>\n"
                   + "    </Destination>\n"
                   + "    <Destination name=\"DEST2\">\n"
                   + "      <From>AMAZON</From>\n"
                   + "    </Destination>\n"
                   + "    <Destination name=\"DEST3\">\n"
                   + "      <From>EBAY</From>\n"
                   + "    </Destination>\n"
                   + "    <Destination name=\"DEST4\">\n"
                   + "      <From>*</From>\n"
                   + "    </Destination>\n"
                   + "  </Destinations>\n"
                   + "</Configuration>";

        String input = "AMAZON"; // or any other input you want to test

        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
            new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8))
        );
        XPathFactory xpathfactory = XPathFactory.newInstance();
        XPath xpath = xpathfactory.newXPath();

        // Select all Destination nodes
        NodeList nodes = (NodeList) xpath.evaluate("/Configuration/Destinations/Destination", doc, XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            Element destinationElement = (Element) nodes.item(i);
            String fromValue = destinationElement.getElementsByTagName("From").item(0).getTextContent();
            String nameValue = destinationElement.getAttribute("name");

            // Handle '*' as wildcard
            if (fromValue.equals("*") || matchWithWildcard(fromValue, input)) {
                System.out.println(nameValue);
            }
        }
    }

    private static boolean matchWithWildcard(String pattern, String input) {
        // Create a regex from the pattern given '*' for any character(s)
        String regex = "^" + Pattern.quote(pattern).replace("\\*", ".*") + "$";
        return input.matches(regex);
    }
}