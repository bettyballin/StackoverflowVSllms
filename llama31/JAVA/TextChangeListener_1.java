import java.lang.String;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class TextChangeListener_1 implements DocumentListener {

    private String previousText;

    @Override
    public void insertUpdate(DocumentEvent e) {
        // Text was inserted, no need to do anything
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Get the current text
        Document document = e.getDocument();
        String currentText = getText(document);

        // Compare the current text with the previous text to find the removed text
        int offset = e.getOffset();
        int length = e.getLength();
        String removedText = previousText.substring(offset, offset + length);

        // Store the current text for the next change
        previousText = currentText;

        // Process the removed text
        System.out.println("Removed text: " + removedText);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // No need to do anything
    }

    private String getText(Document document) {
        try {
            return document.getText(0, document.getLength());
        } catch (Exception ex) {
            // Handle the exception
            return "";
        }
    }

    public void setPreviousText(Document document) {
        previousText = getText(document);
    }

	public static void main(String[] args) {
	}
}