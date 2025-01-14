import javax.management.MBeanServer;
import java.lang.management.ManagementFactory;
import java.util.Map;

public class SessionInfoMBean implements SessionInfo {
    // Implementation of methods defined in SessionInfo interface

    public int getSessionCount() {
        // TODO: Implement method
        return 0;
    }

    public long getAverageSessionSizeBytes() {
        // TODO: Implement method
        return 0L;
    }

    public Map<String, Long> getSessionSizes() {
        // TODO: Implement method
        return null;
    }

    public static void main(String[] args) {
        // Code to run when program starts
    }
}

interface SessionInfo {
    int getSessionCount();
    long getAverageSessionSizeBytes();
    Map<String, Long> getSessionSizes();
}