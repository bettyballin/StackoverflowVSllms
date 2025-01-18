import java.lang.String;

public class NanosecondTimer {
	public static void main(String[] args) {
		long startTime = System.nanoTime(); // Start time
		// Your sorting or searching code block here...
		long endTime   = System.nanoTime(); // End time
		double durationInSeconds = (endTime - startTime) / 1_000_000_000.0; // Convert to seconds from nanoseconds and store as a double for accuracy.
	}
}