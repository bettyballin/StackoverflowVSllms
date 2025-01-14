import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;

public class BorderExample {

    public static void main(String[] args) {
        JTextField textField = new JTextField(20);
        // Initialize the verifier with the text field so it can store its original border
        MyFilenameVerifier verifier = new MyFilenameVerifier(textField);
        textField.setInputVerifier(verifier);

        JFrame frame = new JFrame("Border Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(textField);
        frame.pack();
        frame.setVisible(true);
    }
}

class MyFilenameVerifier extends InputVerifier {

    private Border originalBorder;
    private JTextField textField;

    public MyFilenameVerifier(JTextField textField) {
        this.textField = textField;
        originalBorder = textField.getBorder();
    }

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        boolean passed = text != null && text.trim().length() > 0;
        if (passed) {
            textField.setBorder(originalBorder);
        } else {
            textField.setBorder(BorderFactory.createLineBorder(Color.red));
        }
        return passed;
    }
}