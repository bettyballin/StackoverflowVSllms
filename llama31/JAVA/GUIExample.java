import java.lang.String;
import javax.swing.*;

public class GUIExample {
  public static void main(String[] args) {
    // Create a JFrame (window)
    JFrame frame = new JFrame("GUI Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create a panel to hold the components
    JPanel panel = new JPanel();

    // Input text field
    JTextField textField = new JTextField(20);
    panel.add(new JLabel("Input text:"));
    panel.add(textField);

    // Password field
    JPasswordField passwordField = new JPasswordField(20);
    panel.add(new JLabel("Password:"));
    panel.add(passwordField);

    // Radio buttons
    JRadioButton radioButton1 = new JRadioButton("Option 1");
    JRadioButton radioButton2 = new JRadioButton("Option 2");
    ButtonGroup group = new ButtonGroup();
    group.add(radioButton1);
    group.add(radioButton2);
    panel.add(radioButton1);
    panel.add(radioButton2);

    // Checkboxes
    JCheckBox checkBox1 = new JCheckBox("Check me!");
    JCheckBox checkBox2 = new JCheckBox("Check me too!");
    panel.add(checkBox1);
    panel.add(checkBox2);

    // Text area
    JTextArea textArea = new JTextArea(10, 20);
    panel.add(new JLabel("Text area:"));
    panel.add(new JScrollPane(textArea));

    // Add the panel to the frame and show it
    frame.getContentPane().add(panel);
    frame.pack();
    frame.setVisible(true);
  }
}