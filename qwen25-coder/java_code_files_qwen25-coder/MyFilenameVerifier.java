import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MyFilenameVerifier extends InputVerifier {
    private Border defaultBorder;

    public MyFilenameVerifier(JComponent input) {
        // Store the original/default border of the component
        defaultBorder = input.getBorder();
    }

    @Override
    public boolean verify(JComponent input) {
        // Implement your verification logic here
        // For demonstration purposes, we'll assume the input is valid
        boolean isValid = true; // Replace with actual validation logic

        if (isValid) {
            // If verification passes, restore the default border
            input.setBorder(defaultBorder);
            return true;
        } else {
            // If verification fails, set a red border
            input.setBorder(BorderFactory.createLineBorder(Color.RED));
            return false;
        }
    }

    public static void main(String[] args) {
        // Create a sample text field to attach the verifier
        JTextField textField = new JTextField(20);
        MyFilenameVerifier verifier = new MyFilenameVerifier(textField);
        textField.setInputVerifier(verifier);

        // Create a simple GUI to display the text field
        JFrame frame = new JFrame("InputVerifier Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField);
        frame.pack();
        frame.setVisible(true);
    }
}