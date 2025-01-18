import java.sql.Timestamp;

public class TimeDifferenceCalculator {
    public long getDiff(Timestamp t1, Timestamp t2) {
        // Convert time parts to microseconds and add nanoseconds then subtract one from other.
        // Note that this result will still have duplicate information as both nanoseconds and milliseconds encode the same thing (time units), but it will be resolved in next step.
        long first = t1.getTime() * 1_000 + t1.getNanos();
        long second = t2.getTime() * 1_000 + t2.getNanos();

        // Get difference making it positive using Math.abs to avoid issues with smaller one going first in subtraction.
        // If t1 and t2 are guaranteed to always be non-negative, you can remove Math.abs call.
        long diffMicro = Math.abs(first - second);

        // Convert microseconds into seconds and nanoseconds.
        long diffSeconds = diffMicro / 1_000_000;
        int finalDiffNanos = (int)(diffMicro % 1_000_000); // This cast is safe due to the range limit of int vs long.

        // Combine seconds and nanoseconds into a single long value.
        return (diffSeconds << 32) | (((long) finalDiffNanos) & 0xFFFFFFFFL);
    }

    public static void main(String[] args) {
    }
}