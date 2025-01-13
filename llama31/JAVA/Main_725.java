import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Main_725 {
    public static void main(String[] args) {
        // Create a dialog and a panel
        JDialog dialog = new JDialog();
        JPanel panel = new JPanel();

        // Create a ComponentListener that will listen for the panel's componentRemoved event
        ComponentListener componentListener = new ComponentAdapter() {
            @Override
            public void componentRemoved(ComponentEvent e) {
                // Dispose of the dialog
                dialog.dispose();
            }
        };

        // Add the ComponentListener to the panel
        panel.addComponentListener(componentListener);

        // Add the panel to the dialog
        dialog.add(panel);

        // Set the dialog's size and make it visible
        dialog.setSize(300, 200);
        dialog.setVisible(true);
    }
}