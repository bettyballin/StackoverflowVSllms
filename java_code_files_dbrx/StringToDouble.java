import java.lang.String;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class StringToDouble {
    public static void main(String[] args){
        Locale locale = new Locale("en", "US"); // Change the locale as per your needs
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
        try {
            double output = numberFormat.parse("835,111.2").doubleValue();
            System.out.println(output); // Prints: 835111.2
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}