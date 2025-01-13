import java.lang.String;
public class SynchronizedExample {
    private int sharedVariable = 0;

    public synchronized void increment() {
        // Lock action: invalidate local caches and re-read sharedVariable from main memory
        sharedVariable++;

        // Unlock action: flush changes to sharedVariable back to main memory
    }

	public static void main(String[] args) {
	}
}