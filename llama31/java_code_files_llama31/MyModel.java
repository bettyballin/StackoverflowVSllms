/*
 * Decompiled with CFR 0.152.
 */
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

class MyModel {
    private String text;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void setText(String string) {
        String string2 = this.text;
        this.text = string;
        this.pcs.firePropertyChange("text", string2, string);
    }

    public String getText() {
        return this.text;
    }

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        this.pcs.addPropertyChangeListener(propertyChangeListener);
    }
}
