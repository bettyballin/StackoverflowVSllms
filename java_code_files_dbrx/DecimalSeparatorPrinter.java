import java.lang.String;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DecimalSeparatorPrinter {
    char separator = DecimalFormatSymbols.getInstance(Locale.getDefault()).getGroupingSeparator();
    public DecimalSeparatorPrinter() {
        System.out.printf("Separator:%c%n", separator);
    }
    public static void main(String[] args) {
        new DecimalSeparatorPrinter();
    }
}