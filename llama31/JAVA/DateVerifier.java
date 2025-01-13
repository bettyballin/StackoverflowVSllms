import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DateVerifier extends InputVerifier {
    private final DateFormat dateFormat;

    public DateVerifier(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public boolean verify(JComponent input) {
        if (input instanceof JTextComponent) {
            JTextComponent textComponent = (JTextComponent) input;
            String text = textComponent.getText();
            try {
                dateFormat.parse(text);
                return true;
            } catch (ParseException e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        DateVerifier dateVerifier = new DateVerifier(dateFormat);
        DateVerifier dateTimeVerifier = new DateVerifier(dateTimeFormat);

        JTextArea dateField = new JTextArea();
        dateField.setInputVerifier(dateVerifier);

        JTextArea dateTimeField = new JTextArea();
        dateTimeField.setInputVerifier(dateTimeVerifier);

        JFrame frame = new JFrame("Date Verifier");
        frame.add(dateField);
        frame.add(dateTimeField);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}