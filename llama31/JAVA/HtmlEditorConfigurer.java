import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;

public class HtmlEditorConfigurer {
    JEditorPane editorPane = new JEditorPane();
    HTMLEditorKit editorKit = new HTMLEditorKit();

    public HtmlEditorConfigurer() {
        editorKit.createDefaultDocument();
        CustomTagHTMLDocument document = new CustomTagHTMLDocument();
        editorPane.setEditorKit(editorKit);
        editorPane.setDocument(document);
    }

    public static void main(String[] args) {
        new HtmlEditorConfigurer();
    }
}

// Assuming CustomTagHTMLDocument is a custom class, 
// you would need to define it or import it if it's already defined elsewhere.
class CustomTagHTMLDocument extends javax.swing.text.html.HTMLDocument {
    // Add necessary implementations for CustomTagHTMLDocument
}