import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JTextField;

public class DateValidator {
    private JTextField dateField;

    private void validateDateInput() {
        String input = dateField.getText().trim(); // Get user input without spaces
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            format.setLenient(false); // Make the parser strict
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(format.parse(input)); // Try to parse entered date; throws ParseException if invalid
        } catch (java.text.ParseException e) {
            /* Handle input validation failures */
        }
    }

    public static void main(String[] args) {
    }
}