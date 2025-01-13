/*
 * Decompiled with CFR 0.152.
 */
import java.sql.Timestamp;

public class TimestampCalculator {
    public static Timestamp calculateDifference(Timestamp timestamp, Timestamp timestamp2) {
        long l = Math.abs(timestamp.getTime() - timestamp2.getTime());
        int n = Math.abs(timestamp.getNanos() - timestamp2.getNanos());
        if (n > 1000000000) {
            l += (long)(n / 1000000000);
            n %= 1000000000;
        }
        Timestamp timestamp3 = new Timestamp(l);
        timestamp3.setNanos(n);
        return timestamp3;
    }

    public static void main(String[] stringArray) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.setNanos(500000000);
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        timestamp2.setNanos(800000000);
        Timestamp timestamp3 = TimestampCalculator.calculateDifference(timestamp, timestamp2);
        System.out.println("Difference: " + String.valueOf(timestamp3));
    }
}
