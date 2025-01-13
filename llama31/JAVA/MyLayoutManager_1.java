import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.Container;
import java.awt.Component;
import java.awt.LayoutManager;

public class MyLayoutManager_1_1 implements LayoutManager {
    private PropertyChangeListener listener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("bounds")) {
                if (evt.getOldValue() != null && evt.getNewValue() != null) {
                    // user-induced change
                } else {
                    // automatic change
                }
            }
        }
    };

    @Override
    public void layoutContainer(Container parent) {
        // your layout logic here
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null; // implement this method
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null; // implement this method
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // implement this method
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        addComponent(comp);
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        comp.removePropertyChangeListener(listener);
    }

    public void addComponent(Component comp) {
        comp.addPropertyChangeListener(listener);
    }

    public static void main(String[] args) {
    }
}