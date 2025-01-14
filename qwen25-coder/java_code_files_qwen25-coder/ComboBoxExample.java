import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxExample {
    private String oldValue;
    private JComboBox<String> fooCombo;
    private DefaultComboBoxModel<String> fooModel;

    public ComboBoxExample() {
        // Initialize the model and combo box
        fooModel = new DefaultComboBoxModel<>();
        fooModel.addElement("Item 1");
        fooModel.addElement("Item 2");
        fooModel.addElement("Item 3");

        fooCombo = new JComboBox<>(fooModel);
        
        // Set the initial old value
        oldValue = (String) fooModel.getSelectedItem();

        // Add an ActionListener to handle changes
        fooCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newValue = (String) fooCombo.getSelectedItem();
                if (!newValue.equals(oldValue)) {
                    fooChangedHandler(newValue, oldValue);
                    oldValue = newValue;
                }
            }
        });

        // Add the combo box to a frame for testing
        JFrame frame = new JFrame("ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(fooCombo);
        frame.pack();
        frame.setVisible(true);
    }

    private void fooChangedHandler(String newValue, String oldValue) {
        System.out.println("Old value: " + oldValue + ", New value: " + newValue);
        // Implement your model update logic here
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ComboBoxExample::new);
    }
}