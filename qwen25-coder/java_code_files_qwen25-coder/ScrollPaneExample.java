import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

public class ScrollPaneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JTextPane text = new JTextPane();
            JScrollPane scroll = new JScrollPane(text);
            text.setEditorKit(new HTMLEditorKit());
            try {
                // Load HTML content into the editor
                text.read(ScrollPaneExample.class.getResource("yourfile.html").openStream(), null);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Add a document listener to adjust scroll bar once the document is loaded and laid out.
            ((AbstractDocument) text.getDocument()).addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    adjustScrollBar(text, scroll);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    adjustScrollBar(text, scroll);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    // Not needed for plain text models but included for completeness.
                    adjustScrollBar(text, scroll);
                }

                private void adjustScrollBar(JTextPane pane, JScrollPane scroller) {
                    SwingUtilities.invokeLater(() -> scroller.getVerticalScrollBar().setValue(0));
                }
            });

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scroll);
            frame.setSize(new Dimension(400, 300));
            frame.setVisible(true);
        });
    }
}