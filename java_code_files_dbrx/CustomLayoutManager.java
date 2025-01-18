import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;

public class CustomLayoutManager implements LayoutManager2 {
    private boolean isUserEvent = false;

    @Override
    public void layoutContainer(Container parent) {
        if (!isUserEvent) { // Only perform changes for non-user events.
            // Your code here to adjust component sizes/positions...
            // TODO: implement layout logic
        }
        isUserEvent = false; // Reset the flag for next event.
    }

    public void setIsUserEvent(boolean value) {
        this.isUserEvent = value;
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        // Implementation is required but can be left empty
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        // Implementation is required but can be left empty
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        // Implementation is required but can be left empty
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getMinimumSize();
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return target.getMaximumSize();
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
        // Implementation is required but can be left empty
    }
}