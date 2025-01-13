import org.w3c.dom.Element;
import org.w3c.dom.Document;

public class MyTextBoxWrapper {
    public static void main(String[] args) {
        // Create a new document
        Document document = javax.xml.parsers.DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

        // Create a new element
        Element textbox = document.createElement("myTextBoxId");

        // Create a new MyTextBox instance
        MyTextBox wrapper = new MyTextBox();

        // Wrap the textbox with the wrapper
        wrapper.wrap(textbox);
    }
}

// Assuming MyTextBox class is defined elsewhere
class MyTextBox {
    public void wrap(Element element) {
        // Your implementation here
    }
}