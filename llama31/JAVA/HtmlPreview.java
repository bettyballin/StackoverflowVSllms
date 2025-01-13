import java.lang.String;
import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class HtmlPreview extends JPanel {
    private JEditorPane editor;

    public HtmlPreview(String html) {
        setLayout(new BorderLayout());
        editor = new JEditorPane();
        editor.setEditorKit(new HTMLEditorKit());
        editor.setEditable(false);

        try {
            editor.setPage(new java.io.ByteArrayInputStream(html.getBytes()));
        } catch (Exception e) {
            editor.setText(html);
        }

        add(new JScrollPane(editor), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HTML Preview");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new HtmlPreview("<h1>Hello, World!</h1>"));
        frame.pack();
        frame.setVisible(true);
    }
}