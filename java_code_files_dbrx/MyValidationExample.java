import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.AttributeSet;
import java.awt.Component; // Added import for java.awt.Component

public class MyValidationExample {
    // Define your valid range here
    private static int minValue = 0;
    private static int maxValue = 999;

    // Helper method to ensure entered numbers are within the defined range
    private static String validateNumberRange(String str) {
        try {
            int num = Integer.parseInt(str); // Attempt parse as integer; this will throw exception if not possible
            return (num >= minValue && num <= maxValue) ? str : "";
        } catch (NumberFormatException ignored) {}
        return "";
    }

    // Custom DocumentFilter for real-time validation during typing
    static class NumberDocumentFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int off, String str, AttributeSet attr) throws BadLocationException {
            if (str == null || str.isEmpty()) return; // Do nothing for empty or null inputs
            // Build the new string to check the entire content after insertion
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = new StringBuilder(currentText).insert(off, str).toString();

            String validatedText = validateNumberRange(newText);
            if (!validatedText.isEmpty()) { // Only insert if the new text is valid
                super.insertString(fb, off, str, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attrs) throws BadLocationException {
            if (str == null) return; // Do nothing for null inputs
            // Build the new string to check the entire content after replacement
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText = new StringBuilder(currentText).replace(off, off + len, str).toString();

            String validatedText = validateNumberRange(newText);
            if (!validatedText.isEmpty()) { // Only replace if the new text is valid
                super.replace(fb, off, len, str, attrs);
            }
        }
    }

    // Custom InputVerifier for validation after input is submitted or focus lost
    static class MyInputVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent jc) {
            JTextComponent field = (JTextComponent) jc;
            String val = validateNumberRange(field.getText()); // Ensure number within valid range; empty if not possible or outside of range
            if(!val.isEmpty()) {// If entered value is allowed, set the text to make sure user can submit it
                field.setText(val);
            } else {
                JOptionPane.showMessageDialog((Component)jc,
                    String.format("Please enter a number between %d and %d", minValue, maxValue),
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
                // Display error message if entered value not allowed or empty is returned from validation
            }
            return false; // Always returns false even with valid input because it allows focus switching without submitting the form
        }
    }

    public static void main(String[] args) {
        // Setup code to test the NumberDocumentFilter and MyInputVerifier
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setEditable(true);

        JTextComponent editor = (JTextComponent) comboBox.getEditor().getEditorComponent();

        DefaultStyledDocument doc = new DefaultStyledDocument();
        doc.setDocumentFilter(new NumberDocumentFilter());
        editor.setDocument(doc);

        editor.setInputVerifier(new MyInputVerifier());

        // Create a frame to display the component
        JFrame frame = new JFrame("Validation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(comboBox);
        frame.pack();
        frame.setVisible(true);
    }
}