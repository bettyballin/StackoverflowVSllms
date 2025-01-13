import java.lang.String;
public class Example_14 {
    private final Object lock = new Object();
    private int counter = 0;

    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }

	public static void main(String[] args) {
	}
}