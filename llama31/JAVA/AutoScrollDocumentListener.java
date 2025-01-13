import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class AutoScrollDocumentListener {
    private javax.swing.JTextArea text;
    private javax.swing.JScrollPane scroll;

    public AutoScrollDocumentListener() {
        text = new javax.swing.JTextArea();
        scroll = new javax.swing.JScrollPane(text);

        text.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        scroll.getVerticalScrollBar().setValue(0);
                    }
                });
            }

            public void removeUpdate(DocumentEvent e) {}

            public void changedUpdate(DocumentEvent e) {}
        });
    }

    public static void main(String[] args) {
        new AutoScrollDocumentListener();
    }
}