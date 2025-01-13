import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class HtmlButtonSetter {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Html Button");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String htmlText = "<b>Hello</b> <i>World</i>";
        JButton button = new JButton();
        button.setText(htmlText);

        HTMLEditorKit kit = new HTMLEditorKit();
        HTMLDocument doc = (HTMLDocument) kit.createDefaultDocument();
        doc.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        try {
            kit.insertHTML(doc, 0, htmlText, 0, 0, null);
            button.setText(doc.getText(0, doc.getLength()));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        frame.getContentPane().add(button);
        frame.pack();
        frame.setVisible(true);
    }
}