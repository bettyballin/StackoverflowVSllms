/*
 * Decompiled with CFR 0.152.
 */
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUIExample {
    public static void main(String[] stringArray) {
        JFrame jFrame = new JFrame("GUI Example");
        jFrame.setDefaultCloseOperation(3);
        JPanel jPanel = new JPanel();
        JTextField jTextField = new JTextField(20);
        jPanel.add(new JLabel("Input text:"));
        jPanel.add(jTextField);
        JPasswordField jPasswordField = new JPasswordField(20);
        jPanel.add(new JLabel("Password:"));
        jPanel.add(jPasswordField);
        JRadioButton jRadioButton = new JRadioButton("Option 1");
        JRadioButton jRadioButton2 = new JRadioButton("Option 2");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton);
        buttonGroup.add(jRadioButton2);
        jPanel.add(jRadioButton);
        jPanel.add(jRadioButton2);
        JCheckBox jCheckBox = new JCheckBox("Check me!");
        JCheckBox jCheckBox2 = new JCheckBox("Check me too!");
        jPanel.add(jCheckBox);
        jPanel.add(jCheckBox2);
        JTextArea jTextArea = new JTextArea(10, 20);
        jPanel.add(new JLabel("Text area:"));
        jPanel.add(new JScrollPane(jTextArea));
        jFrame.getContentPane().add(jPanel);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
