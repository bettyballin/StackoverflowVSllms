import java.lang.String;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

public class GmailContactsParser {

    public static void main(String[] args) throws Exception {
        String xmlContent = "<your-xml-content-here>"; // Replace with actual XML content from API response

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        Document document = factory.newDocumentBuilder().parse(new InputSource(new StringReader(xmlContent)));

        NodeList contacts = document.getElementsByTagName("gd:entry"); // Assuming gd namespace for standard contact fields
        for (int i = 0; i < contacts.getLength(); i++) {
            Element entry = (Element) contacts.item(i);

            // Fetching the birthday from the gContact namespace
            String birthdayXmlns = "http://schemas.google.com/contact/2008";
            NodeList birthdays = entry.getElementsByTagNameNS(birthdayXmlns, "birthday");
            if (birthdays.getLength() > 0) {
                String birthday = ((Element) birthdays.item(0)).getAttribute("when");
                System.out.println("Birthday: " + birthday);
            }

            // Fetching the website from the gContact namespace
            NodeList websites = entry.getElementsByTagNameNS(birthdayXmlns, "website");
            for (int j = 0; j < websites.getLength(); j++) {
                Element websiteElement = (Element) websites.item(j);
                String href = websiteElement.getAttribute("href");
                System.out.println("Website: " + href);
            }
        }
    }
}