import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import java.text.DateFormat;

public class DateFieldFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFormattedTextField dateField = new JFormattedTextField(DateFormat.getDateInstance());
        frame.getContentPane().add(dateField);

        frame.pack();
        frame.setVisible(true);
    }
}