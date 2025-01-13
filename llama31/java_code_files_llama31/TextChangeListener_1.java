/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class TextChangeListener_1
implements DocumentListener {
    private String previousText;

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        Document document = documentEvent.getDocument();
        String string = this.getText(document);
        int n = documentEvent.getOffset();
        int n2 = documentEvent.getLength();
        String string2 = this.previousText.substring(n, n + n2);
        this.previousText = string;
        System.out.println("Removed text: " + string2);
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
    }

    private String getText(Document document) {
        try {
            return document.getText(0, document.getLength());
        }
        catch (Exception exception) {
            return "";
        }
    }

    public void setPreviousText(Document document) {
        this.previousText = this.getText(document);
    }

    public static void main(String[] stringArray) {
    }
}
