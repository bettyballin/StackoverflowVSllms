import java.lang.String;
public class InterruptibleTaskThread {
    Thread taskThread = new Thread(() -> {
        while (!Thread.currentThread().isInterrupted()) {
            // Your long-running code here
        }
    });
   
    // To stop the thread, call
    // taskThread.interrupt();

	public static void main(String[] args) {
	}
}