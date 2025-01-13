import java.lang.String;
public class CPUTThrottler {
    private static final long TIME_WINDOW = 1000; // 1 second
    private static final double CPU_USAGE_LIMIT = 0.5; // 50% CPU usage limit

    private long startTime;
    private long sleepTime;

    public void throttle() {
        startTime = System.currentTimeMillis();
        sleepTime = 0;
        while (true) {
            // Your code here...

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            if (elapsedTime > TIME_WINDOW) {
                double cpuUsage = (elapsedTime - sleepTime) / (double) TIME_WINDOW;
                if (cpuUsage > CPU_USAGE_LIMIT) {
                    sleepTime += TIME_WINDOW - (long) (cpuUsage * TIME_WINDOW);
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                startTime = currentTime;
                sleepTime = 0;
            }
        }
    }

	public static void main(String[] args) {
	}
}