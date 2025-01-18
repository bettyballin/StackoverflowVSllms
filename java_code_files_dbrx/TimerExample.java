import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;

public class TimerExample {
    public static void main(String[] args) {
        // Add a timer that checks if the preview generation process is taking longer than expected and stops it.
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Check if the preview generation process has been running for more than 1 minute.
                long startTime = System.currentTimeMillis();
                if (System.currentTimeMillis() - startTime > 60 * 1000) {
                    // Stop the legacy code by killing its processes.
                    try {
                        Runtime.getRuntime().exec("taskkill /F /IM word.exe");
                        Runtime.getRuntime().exec("taskkill /F /IM excel.exe");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 60 * 1000, 60 * 1000); // Run the timer task every minute for the first time and also repeat it every minute.
    }
}