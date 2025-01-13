/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class HtmlButtonSetter {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("Html Button");
        jFrame.setDefaultCloseOperation(3);
        String string = "<b>Hello</b> <i>World</i>";
        JButton jButton = new JButton();
        jButton.setText(string);
        HTMLEditorKit hTMLEditorKit = new HTMLEditorKit();
        HTMLDocument hTMLDocument = (HTMLDocument)hTMLEditorKit.createDefaultDocument();
        hTMLDocument.putProperty("IgnoreCharsetDirective", Boolean.TRUE);
        try {
            hTMLEditorKit.insertHTML(hTMLDocument, 0, string, 0, 0, null);
            jButton.setText(hTMLDocument.getText(0, hTMLDocument.getLength()));
        }
        catch (Exception exception) {
            System.err.println("Error: " + exception.getMessage());
        }
        jFrame.getContentPane().add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
