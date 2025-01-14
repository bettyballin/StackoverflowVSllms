import java.lang.String;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class InlineEditExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inline Edit with Validation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JTree tree = new JTree();
        JScrollPane treeScrollPane = new JScrollPane(tree);

        JPanel dataPanel = new JPanel();
        JLabel label = new JLabel("Parameter:");
        JTextField textField = new JTextField(20);

        // Add validation listener to text field
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { validateData(); }
            @Override
            public void removeUpdate(DocumentEvent e) { validateData(); }
            @Override
            public void changedUpdate(DocumentEvent e) { validateData(); }

            private void validateData() {
                String text = textField.getText();
                // Simple validation example
                if (!text.matches("\\d+")) {
                    label.setForeground(Color.RED);
                    label.setText("Parameter (must be digits):");
                } else {
                    label.setForeground(Color.BLACK);
                    label.setText("Parameter:");
                }
            }
        });

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            if (textField.getForeground().equals(Color.RED)) {
                JOptionPane.showMessageDialog(dataPanel, "Invalid data. Please enter digits only.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Save the data
                System.out.println("Data saved: " + textField.getText());
            }
        });

        dataPanel.add(label);
        dataPanel.add(textField);
        dataPanel.add(saveButton);

        frame.add(treeScrollPane, BorderLayout.WEST);
        frame.add(dataPanel, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }
}