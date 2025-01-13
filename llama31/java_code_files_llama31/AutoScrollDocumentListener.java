/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class AutoScrollDocumentListener {
    private JTextArea text = new JTextArea();
    private JScrollPane scroll = new JScrollPane(this.text);

    public AutoScrollDocumentListener() {
        this.text.getDocument().addDocumentListener(new DocumentListener(){

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
        });
    }

    public static void main(String[] stringArray) {
        new AutoScrollDocumentListener();
    }
}
