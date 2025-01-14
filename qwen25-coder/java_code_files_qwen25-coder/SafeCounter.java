import java.lang.String;
public class SafeCounter {
    private final Object lock = new Object();
    private int count;

    public void increment() {
        synchronized(lock) {
            count++;
        }
    }

    public int getCount() {
        synchronized(lock) {
            return count;
        }
    }

	public static void main(String[] args) {
	}
}