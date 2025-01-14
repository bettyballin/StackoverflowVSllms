import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.Date;

public class ScheduledTasks {

    public void nightlyProcess() {
        // Your batch processing logic here
        System.out.println("Nightly process executed at 11:30 PM");
    }

    public static void main(String[] args) {
        ScheduledTasks scheduledTasks = new ScheduledTasks();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                scheduledTasks.nightlyProcess();
            }
        };

        // Schedule the task to run at 11:30 PM every day
        Timer timer = new Timer();

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 23);
        today.set(Calendar.MINUTE, 30);
        today.set(Calendar.SECOND, 0);

        Date firstRunTime = today.getTime();

        // If the scheduled time is in the past, add one day
        if (firstRunTime.before(new Date())) {
            firstRunTime = new Date(firstRunTime.getTime() + 24 * 60 * 60 * 1000);
        }

        // Schedule the task to run daily at the specified time
        timer.scheduleAtFixedRate(task, firstRunTime, 24 * 60 * 60 * 1000);
    }
}