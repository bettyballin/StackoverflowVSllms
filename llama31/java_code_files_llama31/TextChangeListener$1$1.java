/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.JScrollPane;

class TextChangeListener.1
implements Runnable {
    TextChangeListener.1(TextChangeListener.1 var1_1) {
    }

    @Override
    public void run() {
        ((JScrollPane)scroll).getVerticalScrollBar().setValue(0);
    }
}
