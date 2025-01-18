import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;
import java.io.IOException;
import java.io.StringReader;

public class InsertHTMLExample {
    public static void main(String[] args) throws Exception {
        final String id = "my-id"; // The unique identifier for our span tag.

        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");

        String initialContent = "<html><body><span id=\"my-id\"></span></body></html>";
        editorPane.setText(initialContent);

        HTMLEditorKit kit = (HTMLEditorKit) editorPane.getEditorKit();
        final HTMLDocument doc = (HTMLDocument) editorPane.getDocument();

        final Element[] elementHolder = new Element[1]; // Holder for the element found in the callback

        HTMLEditorKit.Parser parser = new ParserDelegator();
        StringReader reader = new StringReader(initialContent);

        parser.parse(reader, new HTMLEditorKit.ParserCallback() {
            @Override
            public void handleSimpleTag(HTML.Tag t, MutableAttributeSet a, int pos) {
                if (t == HTML.Tag.SPAN && id.equals(a.getAttribute(HTML.Attribute.ID))) { // Check for our span tag with id="my-id"
                    elementHolder[0] = doc.getCharacterElement(pos); // Get the associated Document Element instance containing this Tag.
                }
            }

            @Override
            public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
                if (t == HTML.Tag.SPAN && id.equals(a.getAttribute(HTML.Attribute.ID))) { // Check for our span tag with id="my-id"
                    elementHolder[0] = doc.getCharacterElement(pos); // Get the associated Document Element instance containing this Tag.
                }
            }

            // Implement other methods if necessary for your use case
        }, true);

        Element element = elementHolder[0];

        String actualData = "This is some actual data!"; // Replace placeholder with actual data.

        if (element != null) {
            try {
                kit.insertHTML(doc, element.getStartOffset(), actualData, 0, 0, null); // Insert new HTML content at the position of our span tag.
            } catch (BadLocationException | IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Element with id \"" + id + "\" not found.");
        }

        // Optionally, display the updated content
        System.out.println("Updated Content:\n" + editorPane.getText());
    }
}