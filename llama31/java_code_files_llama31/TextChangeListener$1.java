/*
 * Decompiled with CFR 0.152.
 */
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

class TextChangeListener.1
implements PropertyChangeListener {
    TextChangeListener.1() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getNewValue() == null) {
            SwingUtilities.invokeLater(new Runnable(this){

                @Override
                public void run() {
                    ((JScrollPane)scroll).getVerticalScrollBar().setValue(0);
                }
            });
        }
    }
}
