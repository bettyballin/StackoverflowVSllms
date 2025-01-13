/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JEditorPane;
import javax.swing.text.html.HTMLEditorKit;

public class HtmlEditorConfigurer {
    JEditorPane editorPane = new JEditorPane();
    HTMLEditorKit editorKit = new HTMLEditorKit();

    public HtmlEditorConfigurer() {
        this.editorKit.createDefaultDocument();
        CustomTagHTMLDocument customTagHTMLDocument = new CustomTagHTMLDocument();
        this.editorPane.setEditorKit(this.editorKit);
        this.editorPane.setDocument(customTagHTMLDocument);
    }

    public static void main(String[] stringArray) {
        new HtmlEditorConfigurer();
    }
}
