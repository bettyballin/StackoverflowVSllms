import java.lang.String;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class RichTextLogger {

    private JEditorPane editorPane;
    private StyledDocument doc;

    public RichTextLogger() {
        JFrame frame = new JFrame("Rich Text Logger");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Initialize the editor pane and set it to handle HTML content
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");

        // Get the document model from the editor pane
        doc = (StyledDocument) editorPane.getDocument();

        // Create a scroll pane as the view for the editor pane
        JScrollPane scrollingTextPane = new JScrollPane(editorPane);
        frame.add(scrollingTextPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void appendToLog(Object object) {
        String contentToAdd = "<p>" + object.toString() + "</p>";
        
        // Try to add the new log entry to the document
        try {
            doc.insertString(doc.getLength(), contentToAdd, null);
            
            // Scroll down automatically by setting caret position to the last line of the document
            editorPane.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RichTextLogger logger = new RichTextLogger();
            
            // Simulate appending objects to the log
            logger.appendToLog("First entry");
            logger.appendToLog("Second entry <b>with bold text</b>");
        });
    }
}