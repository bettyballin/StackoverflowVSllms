import org.fife.ui.rsyntaxtextarea.*;
import java.awt.*;
import javax.swing.*;

public class RSyntaxTextAreaExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("RSyntaxTextArea Example");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container cp = frame.getContentPane();

        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60); // Syntax highlighted TextArea
        textArea.setCodeFoldingEnabled(true); // Displays lines in a condensed form (optional)

        // Set the syntax highlighting for XML
        try {
            textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);  // Syntax Highlighting style
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Add a scroll pane to contain our syntax highlighted text area
        JScrollPane sp = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cp.add(sp, BorderLayout.CENTER);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }
}