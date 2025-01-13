import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.event.HierarchyEvent;
import javax.swing.event.HierarchyListener;

public class DisposeListenerExample {
    private JDialog dialog;
    private JPanel panel;

    public DisposeListenerExample() {
        dialog = new JDialog();
        panel = new JPanel();

        // Create a DisposeListener that will listen for the panel's HierarchyEvent
        DisposeListener disposeListener = new DisposeListener();

        // Add the DisposeListener to the panel
        panel.addHierarchyListener(disposeListener);

        dialog.add(panel);
        dialog.pack();
        dialog.setVisible(true);
    }

    // DisposeListener implementation
    class DisposeListener implements HierarchyListener {
        @Override
        public void hierarchyChanged(HierarchyEvent e) {
            // If the panel is being removed from the hierarchy
            if (e.getChangeFlags() == HierarchyEvent.PARENT_CHANGED) {
                // Dispose of the dialog
                dialog.dispose();
            }
        }
    }

    public static void main(String[] args) {
        new DisposeListenerExample();
    }
}