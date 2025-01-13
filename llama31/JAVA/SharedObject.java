import java.lang.String;
public class SharedObject {
    private Object lock = new Object();

    public void update() {
        synchronized (lock) {
            // Update the shared object here
        }
    }

	public static void main(String[] args) {
	}
}