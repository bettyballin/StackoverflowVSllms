import org.joda.time.DateTime;

public class TimestampConverter {
    public static void main(String[] args) {
        DateTime dt = new DateTime();
        java.sql.Timestamp ts = new java.sql.Timestamp(dt.getMillis());
    }
}