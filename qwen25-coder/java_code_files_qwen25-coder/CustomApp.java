import java.lang.String;

public interface CustomAppMBean {
    int getActiveUsers();
    long getTotalRequests();
}

public class CustomApp implements CustomAppMBean {
    private int activeUsers = 0;
    private long totalRequests = 0;

    @Override
    public int getActiveUsers() { return activeUsers; }
    @Override
    public long getTotalRequests() { return totalRequests; }

    // Methods to modify/monitor these data points...

    public static void main(String[] args) {
    }
}