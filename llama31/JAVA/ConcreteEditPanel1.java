import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Define an interface for the panels that will be displayed
public interface EditPanel {
    void populateData(Object data);
    void validateInput();
}

// Create concrete implementations of the EditPanel interface
class ConcreteEditPanel1 extends JPanel implements EditPanel {
    // implementation specific to ConcreteEditPanel1
    @Override
    public void populateData(Object data) {}

    @Override
    public void validateInput() {}
}

class ConcreteEditPanel2 extends JPanel implements EditPanel {
    // implementation specific to ConcreteEditPanel2
    @Override
    public void populateData(Object data) {}

    @Override
    public void validateInput() {}
}

// Create a factory class that returns the correct EditPanel implementation
class EditPanelFactory {
    public static EditPanel createEditPanel(String selectedType) {
        if (selectedType.equals("Type1")) {
            return new ConcreteEditPanel1();
        } else if (selectedType.equals("Type2")) {
            return new ConcreteEditPanel2();
        } else {
            // handle unknown types
            return null;
        }
    }
}

// In your main GUI class, use the factory to create the correct EditPanel
public class MainGUI extends JFrame {
    private JComboBox<String> comboBox;
    private JPanel editPanel;

    public MainGUI() {
        comboBox = new JComboBox<>();
        comboBox.addItem("Type1");
        comboBox.addItem("Type2");

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) comboBox.getSelectedItem();
                EditPanel newEditPanel = EditPanelFactory.createEditPanel(selectedType);
                editPanel.removeAll();
                editPanel.add(newEditPanel);
                editPanel.revalidate();
                editPanel.repaint();
            }
        });

        editPanel = new JPanel();
        add(comboBox, BorderLayout.NORTH);
        add(editPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        MainGUI gui = new MainGUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(400, 300);
        gui.setVisible(true);
    }
}