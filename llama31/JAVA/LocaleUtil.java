import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class LocaleUtil {
    Locale locale = Locale.getDefault();
    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(locale);
    char listSeparator = dfs.getGroupingSeparator();

    public static void main(String[] args) {
    }
}