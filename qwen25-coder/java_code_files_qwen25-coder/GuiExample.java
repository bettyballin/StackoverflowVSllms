import javax.swing.*;
import java.awt.*;

public class GuiExample {
    public static void main(String[] args) {
        // Create a new JFrame container
        JFrame frame = new JFrame("GUI Example");

        // Specify FlowLayout for the layout manager
        frame.setLayout(new FlowLayout());

        // Set Size of the frame
        frame.setSize(300, 200);

        // Terminate the program when the user closes the application.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add text field
        JTextField textField = new JTextField("Input Text", 15);
        frame.add(textField);

        // Add password field
        JPasswordField passwordField = new JPasswordField("Password", 15);
        frame.add(passwordField);

        // Create radio buttons
        JRadioButton radioButton1 = new JRadioButton("Option 1");
        JRadioButton radioButton2 = new JRadioButton("Option 2");
        
        // Group the radio buttons.
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        // Add radio buttons to frame
        frame.add(radioButton1);
        frame.add(radioButton2);

        // Create a checkbox
        JCheckBox checkBox = new JCheckBox("Check me");
        frame.add(checkBox);

        // Add textarea
        JTextArea textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea); // Enable scroll on the text area
        frame.add(scrollPane);

        // Display the frame
        frame.setVisible(true);
    }
}