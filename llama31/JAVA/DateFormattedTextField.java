import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormattedTextField extends JFormattedTextField {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public DateFormattedTextField() {
        super(new DefaultFormatter(format));
        addKeyListener(new DateKeyListener());
    }

    private class DateKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (!Character.isDigit(c)) {
                e.consume();
            } else {
                try {
                    String text = getText();
                    if (text.length() == 2 || text.length() == 5) {
                        // "Jump" to the next number position
                        setText(text + "/");
                        setCaretPosition(text.length() + 1);
                    }
                } catch (Exception ex) {
                    // Handle exception
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
            try {
                String text = getText();
                Date date = format.parse(text);
                // Validate the date
                if (!isValidDate(date)) {
                    // Correct the date or display an error message
                    // ...
                }
            } catch (ParseException ex) {
                // Handle exception
            }
        }
    }

    private boolean isValidDate(Date date) {
        // Implement your own date validation logic here
        // For example:
        return date.after(new Date(0)); // Check if date is after 1970-01-01
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Date Formatted Text Field");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DateFormattedTextField textField = new DateFormattedTextField();
        frame.getContentPane().add(textField);
        frame.pack();
        frame.setVisible(true);
    }
}