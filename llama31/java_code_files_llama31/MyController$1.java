/*
 * Decompiled with CFR 0.152.
 */
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class MyController.1
implements PropertyChangeListener {
    final /* synthetic */ MyView val$view;

    MyController.1() {
        this.val$view = myView;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getPropertyName().equals("text")) {
            this.val$view.updateText((String)propertyChangeEvent.getNewValue());
        }
    }
}
