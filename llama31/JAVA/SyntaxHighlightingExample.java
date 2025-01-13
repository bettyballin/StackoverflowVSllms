import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.lang.String;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

public class SyntaxHighlightingExample {
    public static void main(String[] args) {
        RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
        textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
        textArea.setCodeFoldingEnabled(true);

        // Add the text area to a JFrame or other container
        JFrame frame = new JFrame("Syntax Highlighting Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(textArea));
        frame.pack();
        frame.setVisible(true);
    }
}