import java.lang.String;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class StringToDoubleConverter {
    public static void main(String[] args) {
        String numberStr = "835,111.2";
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        
        try {
            Number number = format.parse(numberStr);
            Double doubleValue = number.doubleValue();
            System.out.println("Converted Double value: " + doubleValue);
        } catch (ParseException e) {
            System.err.println("Error parsing the string to a double: " + e.getMessage());
        }
    }
}