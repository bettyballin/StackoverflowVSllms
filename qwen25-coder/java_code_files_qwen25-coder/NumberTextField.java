import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.text.NumberFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.text.NumberFormat;
import java.awt.Dimension;

public class NumberTextField extends JFormattedTextField {

    private NumberFormatter formatter;
    private NumberFormat nf;

    public NumberTextField() {
        nf = NumberFormat.getInstance();
        formatter = new NumberFormatter(nf);
        formatter.setAllowsInvalid(false);

        // Set a default value to avoid IllegalArgumentException
        setValue(Double.valueOf(0.0d));

        setFormatterFactory(new DefaultFormatterFactory(formatter));
        setMaximumSize(getPreferredSize());  // Optional: Ensure sizing is correct
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new NumberTextField());
        frame.pack();
        frame.setVisible(true);
    }
}