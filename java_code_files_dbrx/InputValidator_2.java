import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class InputValidator_2 extends InputVerifier {
    private final SimpleDateFormat[] formats = new SimpleDateFormat[] {
        new SimpleDateFormat("yyyy-MM-dd"), // date only format
        new SimpleDateFormat("yyyy-MM-dd HH:mm"), // date time with hours and minutes format
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") // full datetime format
    };
    
    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextArea) input).getText();
        for (SimpleDateFormat dateFormat : formats) {
            try {
                // setLenient to false means be very strict & don't skip parts of the pattern.
                dateFormat.setLenient(false);
                Date d = dateFormat.parse(text);
                if (dateFormat.format(d).equals(text)) {
                    return true;
                }
            } catch (ParseException e) {
                // Ignore and try the next format
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // You can add test code here if needed
    }
}