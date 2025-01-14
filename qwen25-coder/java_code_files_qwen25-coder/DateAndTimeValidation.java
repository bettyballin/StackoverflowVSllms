import java.lang.String;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateAndTimeValidation {

    private static class DateInputVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            String text = textField.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(text);
                return true;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(input, "Invalid date. Please use yyyy-MM-dd format.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    private static class DateTimeInputVerifier extends InputVerifier {
        @Override
        public boolean verify(JComponent input) {
            JTextField textField = (JTextField) input;
            String text = textField.getText();
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTimeFormat.setLenient(false);
            try {
                dateTimeFormat.parse(text);
                return true;
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(input, "Invalid date and time. Please use yyyy-MM-dd HH:mm:ss format.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Date and Time Validation");
        JPanel panel = new JPanel();

        JTextField dateField = new JTextField(10);
        dateField.setInputVerifier(new DateInputVerifier());
        panel.add(new JLabel("Enter Date (yyyy-MM-dd):"));
        panel.add(dateField);

        JTextField dateTimeField = new JTextField(20);
        dateTimeField.setInputVerifier(new DateTimeInputVerifier());
        panel.add(new JLabel("Enter Date and Time (yyyy-MM-dd HH:mm:ss):"));
        panel.add(dateTimeField);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}