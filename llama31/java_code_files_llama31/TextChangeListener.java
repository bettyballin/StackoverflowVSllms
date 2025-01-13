/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

class TextChangeListener
implements DocumentListener {
    private String previousText;

    TextChangeListener() {
    }

    public void setPreviousText(Document document) {
        try {
            this.previousText = document.getText(0, document.getLength());
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
    }
}
