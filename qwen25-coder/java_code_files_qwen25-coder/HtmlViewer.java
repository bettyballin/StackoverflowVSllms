import java.lang.String;
import javax.swing.*;
import java.awt.*;

public class HtmlViewer extends JFrame {
    public HtmlViewer() {
        JEditorPane editorPane = new JEditorPane();
        editorPane.setEditable(false);
        
        try {
            // Load HTML content from a string or URL
            editorPane.setContentType("text/html");
            editorPane.setText("<html><body><h1>Hello, World!</h1><p>This is some sample text.</p></body></html>");
            
            // Alternatively, load from a URL
            // editorPane.setPage("http://example.com");

        } catch (Exception e) {
            editorPane.setContentType("text/plain");
            editorPane.setText("An error occurred: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(editorPane);
        this.add(scrollPane, BorderLayout.CENTER);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HtmlViewer viewer = new HtmlViewer();
            viewer.setVisible(true);
        });
    }
}