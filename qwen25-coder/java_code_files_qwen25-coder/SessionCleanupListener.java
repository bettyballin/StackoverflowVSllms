import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCleanupListener implements HttpSessionListener {
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Check if this is part of planned maintenance
        if (!isMaintenanceMode()) {
            // Proceed with normal session cleanup
        }
    }

    private boolean isMaintenanceMode() {
        // Implementation to check for maintenance mode
        return false;
    }

    public static void main(String[] args) {
    }
}