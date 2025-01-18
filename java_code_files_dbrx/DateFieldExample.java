import javax.swing.*;
import javax.swing.text.*;
import java.text.*;

public class DateFieldExample {

    public static void main(String[] args) {
        JFormattedTextField dateField = new JFormattedTextField();
        dateField.setColumns(10); // Set desired amount of columns
        dateField.setFormatterFactory(getDateFormatter()); // Apply format

        // For demonstration purposes, create a frame to display the field
        JFrame frame = new JFrame("Date Field Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(dateField);
        frame.pack();
        frame.setVisible(true);
    }

    private static DefaultFormatterFactory getDateFormatter() {
        DateFormat displayFormat = new SimpleDateFormat("MM/dd/yyyy");
        DateFormatter dateFormatter = new DateFormatter(displayFormat);
        return new DefaultFormatterFactory(dateFormatter);
    }
}