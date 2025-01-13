import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ShutdownListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Disable HttpSessionDestroyedEvent or perform cleanup here
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Required method for ServletContextListener interface
    }

    public static void main(String[] args) {
    }
}