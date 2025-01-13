import java.text.NumberFormat;
import java.text.NumberFormatter;

import javax.swing.JFormattedTextField;

public class NumberTextField extends JFormattedTextField {
    private NumberFormatter formater;
    private NumberFormat nf;

    public NumberTextField() {
        formater = new NumberFormatter();
        formater.setAllowsInvalid(false);
        nf = NumberFormat.getInstance();
        formater.setFormat(nf);

        this.setFormatter(formater);
        this.setValue(new Double(0.0d)); // Set the initial value after setting the formatter
    }

    public static void main(String[] args) {
        new NumberTextField();
    }
}