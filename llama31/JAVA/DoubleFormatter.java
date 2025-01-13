import java.text.NumberFormat;
import javax.swing.text.NumberFormatter;

public class DoubleFormatter {
    NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance()) {
        @Override
        public Object getInitialValue() {
            return new Double(0.0d);
        }
    };

    public static void main(String[] args) {
    }
}