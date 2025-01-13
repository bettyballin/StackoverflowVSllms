import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Main_730 {
    public static void main(String[] args) {
        // Assuming rs is a ResultSet and column is a valid column index
        // Replace with your actual database query and result set handling
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); // For demonstration purposes

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = dateFormat.format(timestamp);

        System.out.println("Formatted Timestamp: " + formattedTimestamp);
    }
}