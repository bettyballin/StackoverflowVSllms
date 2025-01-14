import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import javax.swing.*;
import java.awt.*;

public class SyntaxHighlightingExample {
    public static void main(String[] args) {
        // Set up the frame and text area
        JFrame frame = new JFrame("RSyntaxTextArea Example");
        RSyntaxTextArea textArea = new RSyntaxTextArea();

        // Configure text area with XML syntax highlighting
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
        textArea.setCodeFoldingEnabled(true);  // Optional: code folding

        // Add to a scroll pane
        JScrollPane sp = new JScrollPane(textArea);

        // Show the frame
        frame.add(sp, BorderLayout.CENTER);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}