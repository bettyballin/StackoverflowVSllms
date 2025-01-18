import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class CustomEditorPane {
    private JFrame frame = new JFrame();
    private MyJEditorPane editorPane = new MyJEditorPane();

    public CustomEditorPane() {
        createAndShowGUI();

        final List<YourCustomObject> model = new ArrayList<>();
        Timer timer = new Timer(2000, e -> {
            synchronized (model) {
                YourCustomObject obj = new YourCustomObject("Text" + System.currentTimeMillis()); // create a new object to append it to the list
                model.add(obj);

                editorPane.updateModel(model); // notify our view about changes
            }
        });
        timer.start();
    }

    private void createAndShowGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane scroll = new JScrollPane(editorPane);
        frame.add(scroll);
        frame.pack();
        frame.setVisible(true);
    }

    // Define YourCustomObject class
    private class YourCustomObject {
        private String text;

        public YourCustomObject(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }

    // Define MyDocument class
    private class MyDocument extends PlainDocument {
        // We can override methods if necessary
    }

    private class MyJEditorPane extends JEditorPane implements DocumentListener {
        MyDocument document; // custom document to hold your objects instead of standard ones

        public MyJEditorPane() {
            setContentType("text/html");
            document = new MyDocument();
            setDocument(document);
            document.addDocumentListener(this);
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            SwingUtilities.invokeLater(() -> {
                try {
                    String text = document.getText(0, document.getLength());
                    setText(text);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            });
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            SwingUtilities.invokeLater(() -> {
                try {
                    String text = document.getText(0, document.getLength());
                    setText(text);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }
            });
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // Not used
        }

        public void updateModel(List<YourCustomObject> model) { // this method is called each time model changes, i.e., a new object was added to it
            StringBuilder sb = new StringBuilder();
            for (YourCustomObject obj : model) {
                sb.append("<b>") // you can format your text in whatever way needed here; now let's say each custom object is converted into an HTML tag with bold formatting
                  .append(obj.getText()) // suppose YourCustomObject has a method getText() that returns its text content
                  .append("</b>\n");
            }
            try {
                document.remove(0, document.getLength());
                document.insertString(0, sb.toString(), null); // we don't use `setText`, because it would cause losing document properties; instead, the whole new string is appended to our model (document)
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomEditorPane());
    }
}