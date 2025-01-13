import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class DataPanel {
    private JTextField field1;
    private JTextField field2;

    public DataPanel() {
        // Create a panel for the data
        JPanel dataPanel = new JPanel();
        GroupLayout layout = new GroupLayout(dataPanel);
        dataPanel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Add fields for the parameters
        field1 = new JTextField();
        field2 = new JTextField();

        // Add fields to the panel
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(field1)
                                .addComponent(field2))
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(field1)
                        .addComponent(field2)
        );

        // Add a KeyListener to each field to validate input
        field1.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validateField1();
            }
        });

        field2.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                validateField2();
            }
        });

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(dataPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // Validate methods
    private void validateField1() {
        String text = field1.getText();
        if (!isValid(text)) {
            field1.setBackground(Color.RED);
        } else {
            field1.setBackground(Color.WHITE);
        }
    }

    private void validateField2() {
        // Add your validation logic here
    }

    // Helper method to check if input is valid
    private boolean isValid(String text) {
        // Add your validation logic here
        return true; // or false
    }

    public static void main(String[] args) {
        new DataPanel();
    }
}