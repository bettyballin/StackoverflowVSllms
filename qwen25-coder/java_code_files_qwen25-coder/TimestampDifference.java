import java.lang.String;
import java.sql.Timestamp;

public class TimestampDifference {
    public static void main(String[] args) {
        Timestamp t1 = new Timestamp(1001);
        t1.setNanos(1000000); // 1 millisecond and 1 microsecond

        Timestamp t2 = new Timestamp(999);
        t2.setNanos(999000000); // less than 1 second but almost 1 second

        Timestamp diff = getDifference(t1, t2);

        System.out.println("Diff in milliseconds: " + diff.getTime());
        System.out.println("Diff in nanos: " + diff.getNanos());
    }

    public static Timestamp getDifference(Timestamp t1, Timestamp t2) {
        long timeDiff = t1.getTime() - t2.getTime();
        int nanosDiff = t1.getNanos() - t2.getNanos();

        // Adjust if nanoseconds are negative
        if (nanosDiff < 0) {
            nanosDiff += 1_000_000_000; // Borrow a second's worth of nanoseconds
            timeDiff--; // Subtract the borrowed second from milliseconds
        }

        // Ensure positive difference
        if (timeDiff < 0) {
            timeDiff = -timeDiff;
            nanosDiff = 1_000_000_000 - nanosDiff; // Adjust nanos for the negative case
        }

        return new Timestamp(timeDiff);
    }
}