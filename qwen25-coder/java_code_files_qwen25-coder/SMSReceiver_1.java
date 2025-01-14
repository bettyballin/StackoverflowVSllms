import java.lang.String;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SMSReceiver_1 {

    // This method will be called when an SMS is received
    public void smsReceived() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        
        Runnable task = () -> {
            updateDatabase();
        };
        
        // Schedule the task to run after 3 minutes (180 seconds)
        scheduler.schedule(task, 180, TimeUnit.SECONDS);
    }

    private void updateDatabase() {
        // Your SQL query execution logic here
        System.out.println("Updating database with success status...");
        // Example: execute "UPDATE checks SET status='SUCCESS' WHERE id=..."
    }

    public static void main(String[] args) {
        SMSReceiver_1 receiver = new SMSReceiver_1();
        // Simulate SMS received callback
        receiver.smsReceived();
    }
}