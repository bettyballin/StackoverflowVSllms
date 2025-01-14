import java.lang.String;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date; // Importing SQL Date class to convert LocalDate

public class DateHandler {
    public static void main(String[] args) {
        String inputDate = "1990-05-24"; // Example input date string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        // Parse the string to a LocalDate object
        LocalDate localDate = LocalDate.parse(inputDate, formatter);
        
        // Convert LocalDate to SQL Date for database storage
        java.sql.Date sqlDate = Date.valueOf(localDate);
        
        // Now you can store `sqlDate` in your MySQL database
        System.out.println("Parsed LocalDate: " + localDate);
        System.out.println("SQL Date for storage: " + sqlDate);
    }
}