import java.lang.String;
public class LimitedThread extends Thread {
    public void run() {
        while (true) {
            // Your resource-intensive task here...

            try {
                // Sleep for some time to free up CPU resources.
                Thread.sleep(10); // You can adjust this sleep period, but keep it small enough to not disrupt your overall process execution too much.
            } catch (InterruptedException e) {
                break;
            }
        }
    }

	public static void main(String[] args) {
	}
}