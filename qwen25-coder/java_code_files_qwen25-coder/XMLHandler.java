import java.lang.String;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLHandler {
    public void processXML(Document document) {
        if (document == null) {
            System.err.println("Received null XML document.");
            return;
        }

        Element rootElement = document.getDocumentElement();
        if (rootElement == null) {
            System.err.println("Root element is null in the XML document.");
            return;
        }

        // Further processing ensuring each node is checked for null
        Element childElement = (Element) rootElement.getElementsByTagName("childTag").item(0);
        if (childElement != null && childElement.getTextContent() != null) {
            String content = childElement.getTextContent();
            System.out.println("Child element content: " + content);
        } else {
            System.err.println("Child element or its text content is null.");
        }
    }

	public static void main(String[] args) {
	}
}