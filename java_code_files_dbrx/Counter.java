import java.lang.String;
public class Counter {
    private int count = 0;

    public void increaseCount() {
        // Synchronized block to prevent race condition in multi-threaded environment
        synchronized(this) {
            this.count++;
        }
    }

	public static void main(String[] args) {
	}
}