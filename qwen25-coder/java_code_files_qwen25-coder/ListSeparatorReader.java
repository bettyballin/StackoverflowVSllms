import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ListSeparatorReader {
    public static void main(String[] args) {
        // Get the default locale of the system
        Locale defaultLocale = Locale.getDefault();

        // Obtain DecimalFormatSymbols for the default locale
        DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(defaultLocale);

        // Get the pattern separator character
        char listSeparator = decimalFormatSymbols.getPatternSeparator();

        System.out.println("List separator for the current locale: " + listSeparator);
    }
}