import java.lang.String;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm extends javax.swing.JFrame {

    private void initComponents() {
        // Design generated code by NetBeans...
        dynamicPanel = new javax.swing.JPanel();
        addDynamicButton = new javax.swing.JButton();

        addDynamicButton.setText("Add Button");
        addDynamicButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton newButton = new JButton("New Button");
                dynamicPanel.add(newButton);
                dynamicPanel.revalidate(); // Update layout
                dynamicPanel.repaint();   // Redraw the panel
            }
        });

        // Add components to the frame...
    }

    private javax.swing.JPanel dynamicPanel;
    private javax.swing.JButton addDynamicButton;

    // Main method and other necessary code...

	public static void main(String[] args) {
	}
}