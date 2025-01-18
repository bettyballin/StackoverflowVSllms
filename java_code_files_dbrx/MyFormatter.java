import javax.swing.*;
import java.text.ParseException;

public class MyFormatter extends JFormattedTextField.AbstractFormatter {

    @Override
    protected Object stringToValue(String text) throws ParseException {
        if ((getFormattedTextField().getFormatter() != null) && (!text.trim().equals(""))) {
            return getFormattedTextField().getFormatter().stringToValue(text);
        } else {
            return ""; // or any other suitable value for an empty input, like "0"
        }
    }

    @Override
    protected String valueToString(Object value) throws ParseException {
        if (getFormattedTextField().getFormatter() != null && value != null) {
            return getFormattedTextField().getFormatter().valueToString(value);
        } else {
            return ""; // or any other suitable default value
        }
    }
}