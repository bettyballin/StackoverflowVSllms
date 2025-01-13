import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.text.Document;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

class TextChangeListener implements DocumentListener {
    private String previousText;

    public void setPreviousText(Document document) {
        try {
            previousText = document.getText(0, document.getLength());
        } catch (Exception e) {
            // Handle exception
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        // Implementation for insert update
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        // Implementation for remove update
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        // Implementation for change update
    }
}

public class TextChangeListenerInstaller {
    public static void main(String[] args) {
        JTextComponent textComponent = new JTextArea();
        Document document = textComponent.getDocument();
        TextChangeListener listener = new TextChangeListener();
        listener.setPreviousText(document);
        document.addDocumentListener(listener);
    }
}