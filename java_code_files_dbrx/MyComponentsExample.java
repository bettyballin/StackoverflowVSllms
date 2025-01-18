import java.awt.*;
import javax.swing.*;
public class MyComponentsExample {
    public static void main(String[] args) {
        // Create a JFrame with grid layout (10 rows and 2 columns)
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(10, 2));

        // Input Text (JTextField)
        JLabel textFieldLabel = new JLabel("Text Field:");
        JTextField textField = new JTextField("");
        frame.add(textFieldLabel);
        frame.add(textField);

        // Password Field (JPasswordField)
        JLabel passwordFieldLabel = new JLabel("Password Field:");
        JPasswordField passwordField = new JPasswordField();
        frame.add(passwordFieldLabel);
        frame.add(passwordField);

        // Radio Buttons (JRadioButton + ButtonGroup)
        JLabel radioButtonLabel = new JLabel("Radio Buttons:");
        ButtonGroup group = new ButtonGroup();
        JRadioButton option1 = new JRadioButton("Option 1", true);
        JRadioButton option2 = new JRadioButton("Option 2", false);
        group.add(option1);
        group.add(option2);
        frame.add(radioButtonLabel);
        frame.add(option1);
        frame.add(option2);

        // Checkboxes (JCheckBox)
        JLabel checkboxLabel = new JLabel("Checkboxes:");
        JCheckBox checkbox1 = new JCheckBox("Option 1", true);
        JCheckBox checkbox2 = new JCheckBox("Option 2", false);
        frame.add(checkboxLabel);
        frame.add(checkbox1);
        frame.add(checkbox2);

        // TextArea (JTextArea)
        JLabel textAreaLabel = new JLabel("Text Area:");
        JTextArea textArea = new JTextArea();
        textArea.setColumns(30);
        textArea.setRows(5);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(textAreaLabel);
        frame.add(scrollPane);

        // Configure the JFrame and show it
        frame.pack();
        frame.setVisible(true);
    }
}