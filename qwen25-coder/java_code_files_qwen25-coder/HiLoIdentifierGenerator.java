import java.lang.String;
import java.lang.Integer;

public class HiLoIdentifierGenerator {
    private int hi;
    private int lo = 0;
    private final int maxLow;

    public HiLoIdentifierGenerator(int initialHi, int maxLow) {
        this.hi = initialHi;
        this.maxLow = maxLow;
    }

    public synchronized Integer generate() throws HibernateException {
        if (lo >= maxLow ) {
            // Fetch new hi value from database
            lo = 0;
            hi += 1;
        }
        return hi * maxLow + lo++;
    }

    public static void main(String[] args) {
    }

    // Added the HibernateException class to make the code compile
    public static class HibernateException extends RuntimeException {
        public HibernateException() {}
        public HibernateException(String message) {
            super(message);
        }
    }
}