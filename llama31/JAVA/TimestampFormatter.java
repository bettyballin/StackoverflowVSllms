import java.sql.Timestamp;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class TimestampFormatter {
    public static void main(String[] args) {
        // Example usage:
        TimestampFormatter formatter = new TimestampFormatter();
        formatter.formatTimestamp();
    }

    public void formatTimestamp() {
        // Assuming 'rs' is a ResultSet and 'column' is a column index or name
        ResultSet rs = null; // Initialize with your ResultSet
        int column = 0; // Initialize with your column index or name
        Object obj = rs.getObject(column);
        if (obj instanceof Timestamp) {
            Timestamp timestamp = (Timestamp) obj;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formattedTimestamp = dateFormat.format(timestamp);
            System.out.println(formattedTimestamp); // Use formattedTimestamp as needed
        }
    }
}