import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

public class DateParser {
    public static String parse(String dateString, Locale locale) throws ParseException {
        DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        return format.parse(dateString).toString();  // or another suitable method like toLocaleDateString() etc. depending upon specific application requirement
    }

    public static void main(String[] args) {
    }
}