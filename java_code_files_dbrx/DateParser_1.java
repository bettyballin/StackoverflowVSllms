import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser_1 {
    String inputDate = "1982-03-25"; // Example input date string in yyyy-MM-dd format

    // Parse the input date and create a LocalDate object
    LocalDate localDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);

    // You can perform any operations on this date object now, for example adding days, etc.
    // The timezone will not matter in these calculations.

    public static void main(String[] args) {
    }
}