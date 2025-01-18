import java.lang.String;
public class Counter_1 {
    private int count = 0;

    public synchronized void increment() { // method level synchronization
        count++;
    }

    public void decrement() {
        synchronized (this) { // block level synchronization
            count--;
        }
    }

	public static void main(String[] args) {
	}
}