import java.time.Instant;
import java.sql.Timestamp;

public class MyClass {
    public static void main(String[] args) {
        Instant myDateTime = Instant.now();  // Your date time
        Timestamp timestamp = new Timestamp(myDateTime.toEpochMilli());  // Convert to Timestamp format

        // Optional: print out the timestamp
        System.out.println("Timestamp: " + timestamp);
    }
}