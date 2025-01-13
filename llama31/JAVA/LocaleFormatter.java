import java.text.DecimalFormatSymbols;

public class LocaleFormatter {
    DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance();
    char listSeparator = dfs.getGroupingSeparator();

    public static void main(String[] args) {
    }
}