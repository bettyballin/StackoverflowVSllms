/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JTextArea;
import javax.swing.text.Document;

public class TextChangeListenerInstaller {
    public static void main(String[] stringArray) {
        JTextArea jTextArea = new JTextArea();
        Document document = jTextArea.getDocument();
        TextChangeListener textChangeListener = new TextChangeListener();
        textChangeListener.setPreviousText(document);
        document.addDocumentListener(textChangeListener);
    }
}
