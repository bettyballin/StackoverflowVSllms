import java.lang.String;
import java.lang.Integer;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateEntryExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Date Entry Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new FlowLayout());

            JFormattedTextField dateField = createDateField();
            frame.add(dateField);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JFormattedTextField createDateField() {
        try {
            MaskFormatter dateFormatter = new MaskFormatter("##/##/####");
            dateFormatter.setPlaceholderCharacter('_');

            JFormattedTextField dateField = new JFormattedTextField(dateFormatter);

            // Add a DocumentFilter to validate and adjust the date
            ((AbstractDocument) dateField.getDocument()).setDocumentFilter(new DateValidationFilter());

            return dateField;
        } catch (ParseException e) {
            throw new RuntimeException("Unexpected error initializing date formatter", e);
        }
    }

    private static class DateValidationFilter extends DocumentFilter {
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
            String newText;

            if (text == null) { // User is backspacing or deleting
                newText = currentText.substring(0, offset) + currentText.substring(offset + length);
            } else { // User is typing something
                newText = currentText.substring(0, offset) + text + currentText.substring(offset + length);
            }

            if (isValidDate(newText)) {
                super.replace(fb, 0, fb.getDocument().getLength(), newText, attrs);
            } else {
                Toolkit.getDefaultToolkit().beep(); // Notify user of invalid input
            }
        }

        private boolean isValidDate(String text) {
            try {
                dateFormat.setLenient(false); // Ensure strict parsing
                dateFormat.parse(text);
                return true;
            } catch (ParseException e) {
                // Check if the date can be corrected (simple example with month)
                String[] parts = text.split("/");
                if (parts.length == 3) {
                    int day = Integer.parseInt(parts[0]);
                    int month = Integer.parseInt(parts[1]);
                    int year = Integer.parseInt(parts[2]);

                    // Simple adjustment logic for month
                    if (month > 12) {
                        parts[0] = "01";
                        parts[1] = String.format("%02d", ((year + 1) % 100));
                        parts[2] = String.valueOf(year + 1);
                        return isValidDate(String.join("/", parts));
                    }
                }

                return false;
            }
        }
    }
}