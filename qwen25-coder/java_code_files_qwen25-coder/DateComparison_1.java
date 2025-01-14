import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparison {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        // Assuming expectedDate and actualDate are of type Date
        Date expectedDate = new Date(); // your expected date value
        Date actualDate = new Date();   // the retrieved date value from database

        String formattedExpected = formatter.format(expectedDate);
        String formattedActual = formatter.format(actualDate);

        assertEquals(formattedExpected, formattedActual);  // assertion for comparison
    }

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            throw new AssertionError("expected:<" + expected + "> but was:<" + actual + ">");
        }
    }
}