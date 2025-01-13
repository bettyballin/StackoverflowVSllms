import java.lang.String;
import org.apache.log4j.Logger;

public class ExecutionTimeTracker {
    private static ThreadLocal<ExecutionTimeTracker> instance = new ThreadLocal<>();
    private long startTime;
    private long webServiceTime;
    private long massageTime;

    public static ExecutionTimeTracker getInstance() {
        if (instance.get() == null) {
            instance.set(new ExecutionTimeTracker());
        }
        return instance.get();
    }

    public void startTiming() {
        startTime = System.currentTimeMillis();
    }

    public void startWebServiceTiming() {
        webServiceTime = System.currentTimeMillis();
    }

    public void stopWebServiceTiming() {
        webServiceTime = System.currentTimeMillis() - webServiceTime;
    }

    public void startMassageTiming() {
        massageTime = System.currentTimeMillis();
    }

    public void stopMassageTiming() {
        massageTime = System.currentTimeMillis() - massageTime;
    }

    public long getTotalTime() {
        return System.currentTimeMillis() - startTime;
    }

    public long getWebServiceTime() {
        return webServiceTime;
    }

    public long getMassageTime() {
        return massageTime;
    }
}

// Usage example:
public class MyService {
    private static Logger logger = Logger.getLogger(MyService.class);

    public void processRequest() {
        ExecutionTimeTracker tracker = ExecutionTimeTracker.getInstance();
        tracker.startTiming();

        // Call web service
        tracker.startWebServiceTiming();
        // ...
        tracker.stopWebServiceTiming();

        // Massage data
        tracker.startMassageTiming();
        // ...
        tracker.stopMassageTiming();

        // Log execution times
        logger.info(String.format("%d/%d/%d",
                tracker.getTotalTime(),
                tracker.getWebServiceTime(),
                tracker.getMassageTime()));
    }

    public static void main(String[] args) {
        MyService service = new MyService();
        service.processRequest();
    }
}