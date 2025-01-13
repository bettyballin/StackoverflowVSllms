/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

class AutoScrollDocumentListener.1
implements DocumentListener {
    AutoScrollDocumentListener.1() {
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                AutoScrollDocumentListener.this.scroll.getVerticalScrollBar().setValue(0);
            }
        });
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
    }
}
