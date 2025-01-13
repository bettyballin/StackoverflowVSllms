import java.sql.Timestamp;
import java.lang.Math;

public class TimestampCalculator {
    public static Timestamp calculateDifference(Timestamp t1, Timestamp t2) {
        long timeDiff = Math.abs(t1.getTime() - t2.getTime());
        int nanosDiff = Math.abs(t1.getNanos() - t2.getNanos());

        // Adjust nanos difference if it exceeds 1 second (1 billion nanoseconds)
        if (nanosDiff > 1_000_000_000) {
            timeDiff += nanosDiff / 1_000_000_000;
            nanosDiff %= 1_000_000_000;
        }

        // Create a new Timestamp with the calculated differences
        Timestamp diff = new Timestamp(timeDiff);
        diff.setNanos(nanosDiff);

        return diff;
    }

    public static void main(String[] args) {
        // Example usage:
        Timestamp t1 = new Timestamp(System.currentTimeMillis());
        t1.setNanos(500000000); // Set nanoseconds to 0.5 seconds

        Timestamp t2 = new Timestamp(System.currentTimeMillis());
        t2.setNanos(800000000); // Set nanoseconds to 0.8 seconds

        Timestamp diff = calculateDifference(t1, t2);
        System.out.println("Difference: " + diff);
    }
}